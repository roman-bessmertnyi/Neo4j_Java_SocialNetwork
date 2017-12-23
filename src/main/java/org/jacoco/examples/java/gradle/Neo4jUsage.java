package org.jacoco.examples.java.gradle;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.jacoco.examples.java.gradle.NetworkContent.Group;
import org.jacoco.examples.java.gradle.NetworkContent.Person;
import org.jacoco.examples.java.gradle.NetworkContent.SocialNetwork;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4jUsage {

    private final GraphDatabaseService graphDB;
    private final HashMap<Person, Node> peopleNodes;
    private final HashMap<Group, Node> groupsNodes;
    private final HashMap<String, Node> tweetsNodes;

    public Neo4jUsage() {
        graphDB = new GraphDatabaseFactory().newEmbeddedDatabase(new File("data/socialnetwork"));
        peopleNodes = new HashMap<>();
        groupsNodes = new HashMap<>();
        tweetsNodes = new HashMap<>();
    }

    private void registerShutdownHook(final GraphDatabaseService graphDb) {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                graphDb.shutdown();
            }
        });
    }

    public void closeDB() {
        registerShutdownHook(graphDB);
    }

    public void generateData(int people, int groups) {
        SocialNetwork sn = new SocialNetwork(people, groups);
        insertPeopleToDB(sn.getNetworkPeople());
        setFriendRelations(sn.getNetworkPeople());
        insertGroupsToDB(sn.getNetworkGroups());
        setSubscribersRelations(sn.getNetworkGroups());
        sn.getNetworkPeople().forEach((person)-> insertTweetsToDB(person.getTweetsList()));
        setAuthorRelations(sn.getNetworkPeople());
    }

    private void insertPeopleToDB(ArrayList<Person> people) {
        try (Transaction tx = graphDB.beginTx()) {
            people.forEach((person) -> {
                Node personNode = graphDB.createNode(Label.label("Person"));
                personNode.setProperty("fullName", person.getFullName());
                personNode.setProperty("gender", person.getGender());
                personNode.setProperty("age", person.getAge());
                peopleNodes.put(person, personNode);
            });
            tx.success();
        }
    }

    private void setFriendRelations(ArrayList<Person> people) {
        try (Transaction tx = graphDB.beginTx()) {
            Node persNode, friendNode;
            for (Person person : people) {
                persNode = peopleNodes.get(person);
                for (Person friend : person.getFriendsList()) {
                    friendNode = peopleNodes.get(friend);
                    persNode.createRelationshipTo(friendNode, RelationshipType.withName("FRIENDS"));
                }
            }
            tx.success();
        }
    }

    private void insertGroupsToDB(ArrayList<Group> groups) {
        try (Transaction tx = graphDB.beginTx()) {
            groups.forEach((group) -> {
                Node groupNode = graphDB.createNode(Label.label("Group"));
                groupNode.setProperty("groupName", group.getGroupName());
                groupsNodes.put(group, groupNode);
            });
            tx.success();
        }
    }

    private void setSubscribersRelations(ArrayList<Group> groups) {
        try (Transaction tx = graphDB.beginTx()) {
            Node groupNode, subscriberNode;
            for (Group group : groups) {
                groupNode = groupsNodes.get(group);
                for (Person subscriber : group.getSubscribersList()) {
                    subscriberNode = peopleNodes.get(subscriber);
                    subscriberNode.createRelationshipTo(groupNode, RelationshipType.withName("SUBSCRIBED"));
                }
            }
            tx.success();
        }
    }

    private void insertTweetsToDB(ArrayList<String> tweets) {
        try (Transaction tx = graphDB.beginTx()) {
            tweets.forEach((tweet) -> {
                Node tweetNode = graphDB.createNode(Label.label("Tweet"));
                tweetNode.setProperty("message", tweet);
                tweetNode.setProperty("length", tweet.length());
                tweetsNodes.put(tweet, tweetNode);
            });
            tx.success();
        }
    }
    
    private void setAuthorRelations(ArrayList<Person> people) {
        try (Transaction tx = graphDB.beginTx()) {
            Node personNode, tweetNode;
            for (Person person : people) {
                personNode = peopleNodes.get(person);
                for (String tweet : person.getTweetsList()) {
                    tweetNode = tweetsNodes.get(tweet);
                    personNode.createRelationshipTo(tweetNode, RelationshipType.withName("WROTE"));
                }
            }
            tx.success();
        }
    }
    
    public Result getOrderedPeopleNameList() {
        String query
                = "MATCH (pers:Person) "
                + "RETURN pers.fullName AS People "
                + "ORDER BY People";
        return commonTransaction(query);
    }

    public Result getOrderedByAgeMaleNameAgeList() {
        String query
                = "MATCH (pers:Person) "
                + "WHERE pers.gender = true "
                + "RETURN pers.age AS Age, pers.fullName AS People "
                + "ORDER BY Age DESC";
        return commonTransaction(query);
    }

    public Result getOrderedFriendList(String personFullName) {
        String query
                = "MATCH (pers:Person)"
                + "-[:FRIENDS]-> (friend:Person) "
                + "WHERE pers.fullName = \'" + personFullName + "\' "
                + "RETURN friend.fullName AS Friends "
                + "ORDER BY Friends";
        return commonTransaction(query);
    }

    public Result getOrderedFriendsOfFriendList(String personFullName) {
        String query
                = "MATCH (pers:Person)"
                + "-[:FRIENDS]-> (friend:Person)"
                + "-[:FRIENDS]-> (deepFriend:Person) "
                + "WHERE pers.fullName = \'" + personFullName + "\' "
                + "RETURN deepFriend.fullName AS FriendsOfFriends "
                + "ORDER BY FriendsOfFriends";
        return commonTransaction(query);
    }

    public Result getOrderedFriendsCount() {
        String query
                = "MATCH (pers:Person)"
                + "OPTIONAL MATCH (pers:Person)-[:FRIENDS]-> (friend:Person) "
                + "RETURN length(collect(friend)) AS FriendsCount, pers.fullName AS People "
                + "ORDER BY People";
        return commonTransaction(query);
    }

    public Result getOrderedGroups() {
        String query
                = "MATCH (group:Group) "
                + "RETURN group.groupName AS Groups "
                + "ORDER BY Groups";
        return commonTransaction(query);
    }

    public Result getOrderedGroupsOfPerson(String personFullName) {
        String query
                = "MATCH (pers:Person)"
                + "-[:SUBSCRIBED]-> (group:Group) "
                + "WHERE pers.fullName = \'" + personFullName + "\' "
                + "RETURN group.groupName AS Groups "
                + "ORDER BY Groups";
        return commonTransaction(query);
    }

    public Result getOrderedGroupsCount() {
        String query
                = "MATCH (group:Group)"
                + "OPTIONAL MATCH (pers:Person)-[:SUBSCRIBED]-> (group:Group) "
                + "RETURN group.groupName AS Groups, length(collect(pers)) AS SubscribersCount "
                + "ORDER BY SubscribersCount DESC";
        return commonTransaction(query);
    }

    public Result getOrderedPeopleGroupsCount() {
        String query
                = "MATCH (pers:Person) "
                + "OPTIONAL MATCH (pers)-[:SUBSCRIBED]-> (group) "
                + "RETURN pers.fullName AS People, length(collect(group)) AS GroupsCount "
                + "ORDER BY GroupsCount DESC";
        return commonTransaction(query);
    }

    public Result getDeepFriendsGroupsCount(String personFullName) {
        String query
                = "MATCH (pers:Person)"
                + "-[:FRIENDS]-> (friend:Person)"
                + "-[:FRIENDS]-> (deepFriend:Person)"
                + "-[:SUBSCRIBED]-> (group:Group) "
                + "WHERE pers.fullName = \'" + personFullName + "\' "
                + "RETURN count(group) AS FriendOfFriendGroupsCount";
        return commonTransaction(query);
    }
    
    public Result getPersonTweets(String personFullName) {
        String query
                = "MATCH (pers:Person)"
                + "-[:WROTE]-> (tweet:Tweet)"
                + "WHERE pers.fullName = \'" + personFullName + "\' "
                + "RETURN tweet.message AS PersonTweets "
                + "ORDER BY PersonTweets";
        return commonTransaction(query);
    }
    
    public Result getPeopleAverageLengthTweets() {
        String query
                = "MATCH (pers:Person)"
                + "-[:WROTE]-> (tweet:Tweet) "
                + "RETURN round(10^2 * AVG(tweet.length)) / 10^2 AS AverageTweetLength, pers.fullName AS People "
                + "ORDER BY AverageTweetLength DESC";
        return commonTransaction(query);
    }

    public Result getTweetsMoreThanLength(int length) {
        String query
                = "MATCH (tweet:Tweet) "
                + "WHERE tweet.length > " + length + " "
                + "RETURN tweet.message AS Tweets "
                + "ORDER BY Tweets";
        return commonTransaction(query);
    }
    
    public Result getPeopleTweetsCount() {
        String query
                = "MATCH (pers:Person)"
                + "-[:WROTE]-> (tweet:Tweet) "
                + "RETURN length(collect(tweet.message)) AS TweetsCount, pers.fullName AS People "
                + "ORDER BY TweetsCount DESC";
        return commonTransaction(query);
    }
    
    public Result getDeepFriendsTweetsOfPerson(String personFullName) {
        String query
                = "MATCH (pers:Person)"
                + "-[:FRIENDS]-> (friend:Person)"
                + "-[:FRIENDS]-> (deepFriend:Person)"
                + "-[:WROTE]-> (tweet:Tweet) "
                + "WHERE pers.fullName = \'" + personFullName + "\' "
                + "RETURN tweet.message AS DeepFriendTweets "
                + "ORDER BY DeepFriendTweets";
        return commonTransaction(query);
    }
    
    private Result commonTransaction(String query) {
        Result resultIterator;
        try (Transaction tx = graphDB.beginTx()) {
            resultIterator = graphDB.execute(query);
            tx.success();
        }
        return resultIterator;
    }

    public static void printResults(Result res) {
        String cols = "", rows, line = "____________________________________";
        Iterator<String> colsIterator = res.columns().iterator();
        Map<String, Object> row;
        while (colsIterator.hasNext()) {
            cols += " | " + colsIterator.next() + " | ";
        }
        System.out.println(cols + "\n" + line);
        while (res.hasNext()) {
            rows = "";
            row = res.next();
            for (Object column : row.values()) {
                rows += " | " + column.toString() + " | ";
            }
            if (res.hasNext()) {
                rows += "\n";
            }
            System.out.println(rows);
        }
        System.out.println(line);
    }

}
