/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle.NetworkContent;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Никита
 */
public class PersonTest {
    
    private Person mainInstance = new Person("_name", "_surname", "_secondName", Boolean.TRUE, 0);
    
    /**
     * Test of getFullName method, of class Person.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Person instance = mainInstance;
        String expResult = "_name _surname _secondName";
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of makeFriends method, of class Person.
     */
    @Test
    public void testMakeFriends_Person() {
        System.out.println("makeFriends");
        Person person = new Person("n", "sn", "sN", Boolean.TRUE, 20);
        Person instance = mainInstance;
        instance.makeFriends(person);
        assertFalse(person.getFriendsList().isEmpty());
        assertFalse(instance.getFriendsList().isEmpty());
    }

    /**
     * Test of makeFriends method, of class Person.
     */
    @Test
    public void testMakeFriends_ArrayList() {
        System.out.println("makeFriends");
        ArrayList<Person> personList = new ArrayList<>();
        Person p1 = new Person("name1", "surname", "secName", Boolean.FALSE, 11);
        personList.add(p1);
        Person p2 = new Person("name2", "surname", "secName", Boolean.TRUE, 12);
        personList.add(p2);
        Person instance = mainInstance;
        instance.makeFriends(personList);
        assertEquals(personList.size(), instance.getFriendsList().size());
    }

    /**
     * Test of publishTweet method, of class Person.
     */
    @Test
    public void testPublishTweet() {
        System.out.println("publishTweet");
        String message = "message";
        Person instance = mainInstance;
        instance.publishTweet(message);
        assertEquals(1, instance.getTweetsList().size());
    }

    /**
     * Test of subscribeGroup method, of class Person.
     */
    @Test
    public void testSubscribeGroup() {
        System.out.println("subscribeGroup");
        Group group = new Group("group1");
        Person instance = mainInstance;
        instance.subscribeGroup(group);
        assertEquals(1, instance.getGroupsList().size());
        assertFalse(group.getSubscribersList().isEmpty());
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "name";
        Person instance = new Person("name1", "surname", "secName", Boolean.FALSE, 11);
        instance.setName(name);
        assertEquals("name surname secName", instance.getFullName());
    }

    /**
     * Test of setSurname method, of class Person.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "surname";
        Person instance = new Person("name", "surname1", "secName", Boolean.FALSE, 11);
        instance.setSurname(surname);
        assertEquals("name surname secName", instance.getFullName());

    }

    /**
     * Test of setSecondName method, of class Person.
     */
    @Test
    public void testSetSecondName() {
        System.out.println("setSecondName");
        String secondName = "secName";
        Person instance = new Person("name", "surname", "secName1", Boolean.FALSE, 11);
        instance.setSecondName(secondName);
        assertEquals("name surname secName", instance.getFullName());
    }

    /**
     * Test of getGender method, of class Person.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Person instance = mainInstance;
        Boolean expResult = Boolean.TRUE;
        Boolean result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGender method, of class Person.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        Boolean gender = Boolean.TRUE;
        Person instance = new Person("name", "surname", "secName1", Boolean.FALSE, 11);
        instance.setGender(gender);
        assertEquals(gender, instance.getGender());
    }

    /**
     * Test of getAge method, of class Person.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Person instance = mainInstance;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class Person.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 9;
        Person instance = new Person("name", "surname", "secName1", Boolean.FALSE, 11);
        instance.setAge(age);
        assertEquals(age, instance.getAge());
    }

    /**
     * Test of getFriendsList method, of class Person.
     */
    @Test
    public void testGetFriendsList() {
        System.out.println("getFriendsList");
        ArrayList<Person> personList = new ArrayList<>();
        Person p1 = new Person("name1", "surname", "secName", Boolean.FALSE, 11);
        personList.add(p1);
        Person p2 = new Person("name2", "surname", "secName", Boolean.TRUE, 12);
        personList.add(p2);
        Person instance = mainInstance;
        instance.makeFriends(personList);
        ArrayList<Person> result = instance.getFriendsList();
        assertFalse(result.isEmpty());
    }

    /**
     * Test of getGroupsList method, of class Person.
     */
    @Test
    public void testGetGroupsList() {
        System.out.println("getGroupsList");
        Group group = new Group("gr1");
        Person instance = mainInstance;
        instance.subscribeGroup(group);
        ArrayList<Group> result = instance.getGroupsList();
        assertEquals(group, result.get(0));
    }

    /**
     * Test of getTweetsList method, of class Person.
     */
    @Test
    public void testGetTweetsList() {
        System.out.println("getTweetsList");
        Person instance = mainInstance;
        ArrayList<String> tweetsList = new ArrayList<>();
        tweetsList.add("tweet1");
        tweetsList.add("tweet2");
        instance.setTweetsList(tweetsList);
        ArrayList<String> result = instance.getTweetsList();
        assertFalse(result.isEmpty());
    }

    /**
     * Test of setTweetsList method, of class Person.
     */
    @Test
    public void testSetTweetsList() {
        System.out.println("setTweetsList");
        ArrayList<String> tweetsList = new ArrayList<>();
        tweetsList.add("tweet1");
        tweetsList.add("tweet2");
        Person instance = mainInstance;
        instance.setTweetsList(tweetsList);
        assertFalse(instance.getTweetsList().isEmpty());
    }
    
}
