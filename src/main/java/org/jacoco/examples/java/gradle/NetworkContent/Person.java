/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jacoco.examples.java.gradle.NetworkContent;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;


public class Person {
    @Setter
    private String name;
    @Setter
    private String surname;
    @Setter
    private String secondName;
    @Getter @Setter
    private Boolean gender;
    @Getter @Setter
    private int age;
    @Getter
    private final ArrayList<Person> friendsList;
    @Getter
    private final ArrayList<Group> groupsList;
    @Getter @Setter
    private ArrayList<String> tweetsList;
    
    public Person(String _name, String _surname, String _secondName, Boolean _gender, int _age){
        name = _name;
        surname = _surname;
        secondName = _secondName;
        gender = _gender;
        age = _age;
        friendsList = new ArrayList<>();
        groupsList = new ArrayList<>();
        tweetsList = new ArrayList<>();
    }
    
    public String getFullName(){
        if(!name.isEmpty() && !surname.isEmpty() && !secondName.isEmpty()) 
            return name + " " + surname + " " + secondName;
        else return null;
    }
    
    public void makeFriends(Person person){
        if(person != null && !friendsList.contains(person)){
            friendsList.add(person);
            person.getFriendsList().add(this);
        }
    }
    
    public void makeFriends(ArrayList<Person> personList){
        if(!personList.isEmpty() && !friendsList.containsAll(personList)){
            friendsList.addAll(personList);
            personList.forEach((newFriend) -> {newFriend.getFriendsList().add(this);});
        }
    }
    
    public void publishTweet(String message){
        if(!message.isEmpty()) tweetsList.add(message);
    }
    
    public void subscribeGroup(Group group){
        if(group != null && !groupsList.contains(group)){
            group.subscribe(this);
            groupsList.add(group);
        }
    }
    
}
