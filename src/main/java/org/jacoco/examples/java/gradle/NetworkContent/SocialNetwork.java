/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle.NetworkContent;

import java.util.ArrayList;
import java.util.Random;
import lombok.Getter;


public class SocialNetwork {

    private final Random rnd = new Random();
    @Getter
    private ArrayList<Person> networkPeople;
    @Getter
    private final ArrayList<Group> networkGroups;

    public SocialNetwork(int peopleCount, int groupsCount) {
        Person newPerson;
        int friendsCount, friendIndex;

        networkPeople = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            newPerson = getGeneratedPerson(i);
            newPerson.setTweetsList(getGeneratedTweets());
            networkPeople.add(newPerson);
        }
        //-2 is to set the minimum and extract the person,
        //with whom friends will be made
        for (Person pers : networkPeople) {
            friendsCount = rnd.nextInt(networkPeople.size() - 2) + 1;
            //-2 is to handle overflow exception of index
            for (int i = 0; i < friendsCount; i++) {
                friendIndex = rnd.nextInt(networkPeople.size() - 2) + 1;
                if (networkPeople.indexOf(pers) == friendIndex) {
                    i--;
                    continue;
                }
                pers.makeFriends(networkPeople.get(friendIndex));
            }
        }
        networkGroups = new ArrayList<>();
        for (int i = 0; i < groupsCount; i++) 
            networkGroups.add(getGeneratedGroup(i, networkPeople));
    }

    private Person getGeneratedPerson(int orderNumber) {
        return new Person(
                "name" + orderNumber,
                "surname" + orderNumber,
                "secondName" + orderNumber,
                rnd.nextBoolean(),
                rnd.nextInt(88) + 12
        );
    }

    private ArrayList<String> getGeneratedTweets() {
        ArrayList<String> result = new ArrayList<>();
        int tweetsCount = rnd.nextInt(14) + 1;

        for (int i = 0; i < tweetsCount; i++)
            result.add("tweet" + i);
        return result;
    }

    private Group getGeneratedGroup(int orderNumber, ArrayList<Person> people) {
        Group group = new Group("groupname" + orderNumber);
        int subscrCount = rnd.nextInt(people.size());
        int personIndex;

        for (int i = 0; i < subscrCount; i++) {
            personIndex = rnd.nextInt(people.size() - 1) + 1;
            if (group.getSubscribersList().contains(people.get(personIndex))) {
                i--;
                continue;
            }
            people.get(personIndex).subscribeGroup(group);
        }
        return group;
    }

}
