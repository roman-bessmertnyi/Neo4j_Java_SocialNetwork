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
public class GroupTest {

    /**
     * Test of subscribe method, of class Group.
     */
    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        Person person = new Person("_name", "_surname", "_secondName", Boolean.TRUE, 0);
        Group instance = new Group("_groupName");
        instance.subscribe(person);
        assertFalse(instance.getSubscribersList().isEmpty());
    }

    /**
     * Test of getGroupName method, of class Group.
     */
    @Test
    public void testGetGroupName() {
        System.out.println("getGroupName");
        Group instance = new Group("_groupName");
        String expResult = "_groupName";
        String result = instance.getGroupName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGroupName method, of class Group.
     */
    @Test
    public void testSetGroupName() {
        System.out.println("setGroupName");
        String groupName = "name";
        Group instance = new Group("_groupName");
        instance.setGroupName(groupName);
        assertEquals(groupName, instance.getGroupName());
    }

    /**
     * Test of getSubscribersList method, of class Group.
     */
    @Test
    public void testGetSubscribersList() {
        System.out.println("getSubscribersList");
        Group instance = new Group("_groupName");
        Person person = new Person("_name", "_surname", "_secondName", Boolean.TRUE, 0);
        instance.subscribe(person);
        ArrayList<Person> expResult = new ArrayList<>();
        expResult.add(person);
        ArrayList<Person> result = instance.getSubscribersList();
        assertEquals(expResult, result);
    }
    
}
