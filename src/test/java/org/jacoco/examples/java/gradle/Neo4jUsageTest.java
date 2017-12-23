    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.neo4j.graphdb.Result;

/**
 *
 * @author Никита
 */
public class Neo4jUsageTest {
    
    private static Neo4jUsage instance;
    private final String name = "name1 surname1 secondName1";
    
    @BeforeClass
    public static void setUpClass() {
        instance = new Neo4jUsage();
        //instance.generateData(20, 5);
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance.closeDB();
    }
    
    @Before
    public void setUp(){
        Runtime.getRuntime().gc();
    }
    
    private int resultRowCount(Result res){
        int count = 0;
        while(res.hasNext())
            if(res.next() != null) count++;
        return count;
    }
    
    /**
     * Test of getOrderedPeopleNameList method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedPeopleNameList() {
        System.out.println("getOrderedPeopleNameList");
        assertEquals(20, resultRowCount(instance.getOrderedPeopleNameList()));
    }

    /**
     * Test of getOrderedByAgeMaleNameAgeList method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedByAgeMaleNameAgeList() {
        System.out.println("getOrderedByAgeMaleNameAgeList");
        assertEquals(8, resultRowCount(instance.getOrderedByAgeMaleNameAgeList()));
    }

    /**
     * Test of getOrderedFriendList method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedFriendList() {
        System.out.println("getOrderedFriendList");
        assertEquals(13, resultRowCount(instance.getOrderedFriendList(name)));
    }

    /**
     * Test of getOrderedFriendsOfFriendList method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedFriendsOfFriendList() {
        System.out.println("getOrderedFriendsOfFriendList");
        assertEquals(161, resultRowCount(instance.getOrderedFriendsOfFriendList(name)));
    }

    /**
     * Test of getOrderedFriendsCount method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedFriendsCount() {
        System.out.println("getOrderedFriendsCount");
        assertEquals(20, resultRowCount(instance.getOrderedFriendsCount()));
    }

    /**
     * Test of getOrderedGroups method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedGroups() {
        System.out.println("getOrderedGroups");
        assertEquals(5, resultRowCount(instance.getOrderedGroups()));
    }

    /**
     * Test of getOrderedGroupsOfPerson method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedGroupsOfPerson() {
        System.out.println("getOrderedGroupsOfPerson");
        assertEquals(2, resultRowCount(instance.getOrderedGroupsOfPerson(name)));
    }

    /**
     * Test of getOrderedGroupsCount method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedGroupsCount() {
        System.out.println("getOrderedGroupsCount");
        assertEquals(5, resultRowCount(instance.getOrderedGroupsCount()));
    }

    /**
     * Test of getOrderedPeopleGroupsCount method, of class Neo4jUsage.
     */
    @Test
    public void testGetOrderedPeopleGroupsCount() {
        System.out.println("getOrderedPeopleGroupsCount");
        assertEquals(20, resultRowCount(instance.getOrderedPeopleGroupsCount()));
    }

    /**
     * Test of getDeepFriendsGroupsCount method, of class Neo4jUsage.
     */
    @Test
    public void testGetDeepFriendsGroupsCount() {
        System.out.println("getDeepFriendsGroupsCount");
        assertEquals(1, resultRowCount(instance.getDeepFriendsGroupsCount(name)));
    }

    /**
     * Test of getPersonTweets method, of class Neo4jUsage.
     */
    @Test
    public void testGetPersonTweets() {
        System.out.println("getPersonTweets");
        assertEquals(3, resultRowCount(instance.getPersonTweets(name)));
    }

    /**
     * Test of getPeopleAverageLengthTweets method, of class Neo4jUsage.
     */
    @Test
    public void testGetPeopleAverageLengthTweets() {
        System.out.println("getPeopleAverageLengthTweets");
        assertEquals(20, resultRowCount(instance.getPeopleAverageLengthTweets()));
    }

    /**
     * Test of getTweetsMoreThanLength method, of class Neo4jUsage.
     */
    @Test
    public void testGetTweetsMoreThanLength() {
        System.out.println("getTweetsMoreThanLength");
        int length = 6;
        assertEquals(10, resultRowCount(instance.getTweetsMoreThanLength(length)));
    }

    /**
     * Test of getPeopleTweetsCount method, of class Neo4jUsage.
     */
    @Test
    public void testGetPeopleTweetsCount() {
        System.out.println("getPeopleTweetsCount");
        assertEquals(20, resultRowCount(instance.getPeopleTweetsCount()));
    }

    /**
     * Test of getDeepFriendsTweetsOfPerson method, of class Neo4jUsage.
     */
    @Test
    public void testGetDeepFriendsTweetsOfPerson() {
        System.out.println("getDeepFriendsTweetsOfPerson");
        assertEquals(1019, resultRowCount(instance.getDeepFriendsTweetsOfPerson(name)));
    }
    
}
