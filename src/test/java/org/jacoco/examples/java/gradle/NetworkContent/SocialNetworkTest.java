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
public class SocialNetworkTest {
    
    private SocialNetwork mainInstance = new SocialNetwork(10, 3);
    /**
     * Test of getNetworkPeople method, of class SocialNetwork.
     */
    @Test
    public void testGetNetworkPeople() {
        System.out.println("getNetworkPeople");
        SocialNetwork instance = mainInstance;
        ArrayList<Person> result = instance.getNetworkPeople();
        assertEquals(10, result.size());
    }

    /**
     * Test of getNetworkGroups method, of class SocialNetwork.
     */
    @Test
    public void testGetNetworkGroups() {
        System.out.println("getNetworkGroups");
        SocialNetwork instance = mainInstance;
        ArrayList<Group> result = instance.getNetworkGroups();
        assertEquals(3, result.size());
    }
    
}
