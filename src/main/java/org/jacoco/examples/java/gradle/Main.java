/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import java.io.IOException;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        //start
        Neo4jUsage instance = new Neo4jUsage();
        String name = "name1 surname1 secondName1";
        
        //operations
        //instance.generateData(20, 5);
        Neo4jUsage.printResults(instance.getOrderedPeopleNameList());
        Neo4jUsage.printResults(instance.getOrderedByAgeMaleNameAgeList());
        Neo4jUsage.printResults(instance.getOrderedFriendList(name));
        Neo4jUsage.printResults(instance.getOrderedFriendsOfFriendList(name));
        Neo4jUsage.printResults(instance.getOrderedFriendsCount());
        Neo4jUsage.printResults(instance.getOrderedGroups());
        Neo4jUsage.printResults(instance.getOrderedGroupsOfPerson(name));
        Neo4jUsage.printResults(instance.getOrderedGroupsCount());
        Neo4jUsage.printResults(instance.getOrderedPeopleGroupsCount());
        Neo4jUsage.printResults(instance.getDeepFriendsGroupsCount(name));
        Neo4jUsage.printResults(instance.getPersonTweets(name));
        Neo4jUsage.printResults(instance.getPeopleAverageLengthTweets());
        Neo4jUsage.printResults(instance.getTweetsMoreThanLength(6));
        Neo4jUsage.printResults(instance.getPeopleTweetsCount());
        Neo4jUsage.printResults(instance.getDeepFriendsTweetsOfPerson(name));

        //end
        instance.closeDB();
    }
}
