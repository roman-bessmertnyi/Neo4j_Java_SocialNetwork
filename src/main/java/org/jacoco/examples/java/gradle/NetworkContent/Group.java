/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle.NetworkContent;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class Group {
    @Getter @Setter
    private String groupName;
    @Getter
    private final ArrayList<Person> subscribersList;
    
    public Group(String _groupName){
        groupName = _groupName;
        subscribersList = new ArrayList<>();
    }
    
    public void subscribe(Person person){
        if(person != null && !subscribersList.contains(person)) subscribersList.add(person);
    }
}
