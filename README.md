[![Build Status](https://travis-ci.org/KithStrelets/Neo4j_Java_SocialNetwork.svg?branch=master)](https://travis-ci.org/KithStrelets/Neo4j_Java_SocialNetwork)
[![codecov](https://codecov.io/gh/KithStrelets/Neo4j_Java_SocialNetwork/branch/master/graph/badge.svg)](https://codecov.io/gh/KithStrelets/Neo4j_Java_SocialNetwork)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/86a6f4bff2b74666b03657aa0a1cb552)](https://www.codacy.com/app/KithStrelets/Neo4j_Java_SocialNetwork?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=KithStrelets/Neo4j_Java_SocialNetwork&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/86a6f4bff2b74666b03657aa0a1cb552)](https://www.codacy.com/app/KithStrelets/Neo4j_Java_SocialNetwork?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=KithStrelets/Neo4j_Java_SocialNetwork&amp;utm_campaign=Badge_Coverage)

----------

![graph](https://raw.githubusercontent.com/KithStrelets/Neo4j_Java_SocialNetwork/master/graph.png)

----------


* Выдать упорядоченный список ФИО персон  

         | People |  
         ____________________________________  
         | name0 surname0 secondName0 | 

         | name1 surname1 secondName1 | 

         | name10 surname10 secondName10 | 

         | name11 surname11 secondName11 | 

         | name12 surname12 secondName12 | 

         | name13 surname13 secondName13 | 

         | name14 surname14 secondName14 | 

         | name15 surname15 secondName15 | 

         | name16 surname16 secondName16 | 

         | name17 surname17 secondName17 | 

         | name18 surname18 secondName18 | 

         | name19 surname19 secondName19 | 

         | name2 surname2 secondName2 | 

         | name3 surname3 secondName3 | 

         | name4 surname4 secondName4 | 

         | name5 surname5 secondName5 | 

         | name6 surname6 secondName6 | 

         | name7 surname7 secondName7 | 

         | name8 surname8 secondName8 | 

         | name9 surname9 secondName9 | 
        ____________________________________  
 


----------


* Выдать список ФИО мужчин с указанием возраста, упорядоченный по убыванию возраста


	    | Age |  | People | 
        ____________________________________
        | 95 |  | name4 surname4 secondName4 | 

        | 77 |  | name2 surname2 secondName2 | 

        | 54 |  | name1 surname1 secondName1 | 

        | 52 |  | name0 surname0 secondName0 | 

        | 52 |  | name15 surname15 secondName15 | 

        | 48 |  | name6 surname6 secondName6 | 

        | 41 |  | name14 surname14 secondName14 | 

        | 38 |  | name18 surname18 secondName18 | 
        ____________________________________ 
 


----------


* Выдать упорядоченный список ФИО друзей персоны заданными ФИО ("name1 surname1 secondName1")

	     | Friends | 
        ____________________________________
         | name10 surname10 secondName10 | 

         | name12 surname12 secondName12 | 

         | name14 surname14 secondName14 | 

         | name16 surname16 secondName16 | 

         | name17 surname17 secondName17 | 

         | name18 surname18 secondName18 | 

         | name2 surname2 secondName2 | 

         | name3 surname3 secondName3 | 

         | name4 surname4 secondName4 | 

         | name5 surname5 secondName5 | 

         | name6 surname6 secondName6 | 

         | name7 surname7 secondName7 | 

         | name9 surname9 secondName9 | 
        ____________________________________  
 


----------


* Выдать упорядоченный список ФИО друзей друзей персоны заданными ФИО ("name1 surname1 secondName1")  

	     | FriendsOfFriends | 
        ____________________________________
         | name0 surname0 secondName0 |   
         ---------------+159+---------------
         | name9 surname9 secondName9 | 
        ____________________________________

----------


* Выдать упорядоченный по алфавиту список ФИО персон, в котором для каждой персоны указано количество друзей    

    	 | FriendsCount |  | People | 
        ____________________________________
         | 2 |  | name0 surname0 secondName0 | 

         | 13 |  | name1 surname1 secondName1 | 

         | 9 |  | name10 surname10 secondName10 | 

         | 11 |  | name11 surname11 secondName11 | 

         | 9 |  | name12 surname12 secondName12 | 

         | 15 |  | name13 surname13 secondName13 | 

         | 12 |  | name14 surname14 secondName14 | 

         | 5 |  | name15 surname15 secondName15 | 

         | 13 |  | name16 surname16 secondName16 | 

         | 16 |  | name17 surname17 secondName17 | 

         | 13 |  | name18 surname18 secondName18 | 

         | 6 |  | name19 surname19 secondName19 | 

         | 11 |  | name2 surname2 secondName2 | 

         | 12 |  | name3 surname3 secondName3 | 

         | 15 |  | name4 surname4 secondName4 | 

         | 13 |  | name5 surname5 secondName5 | 

         | 12 |  | name6 surname6 secondName6 | 

         | 13 |  | name7 surname7 secondName7 | 

         | 13 |  | name8 surname8 secondName8 | 

         | 13 |  | name9 surname9 secondName9 | 
        ____________________________________     
 


----------


* Выдать упорядоченный список групп социальной сети  

	     | Groups | 
        ____________________________________
         | groupname0 | 

         | groupname1 | 

         | groupname2 | 

         | groupname3 | 

         | groupname4 | 
        ____________________________________ 
 


----------


* Выдать упорядоченный список групп персоны с заданными ФИО ("name1 surname1 secondName1")

    	 | Groups | 
        ____________________________________
         | groupname3 | 

         | groupname4 | 
        ____________________________________
 


----------


* Выдать список групп социальной сети с указанием количества членов каждой группы, упорядоченный по убыванию количества членов группы    

    	 | Groups |  | SubscribersCount | 
        ____________________________________
         | groupname3 |  | 10 | 

         | groupname4 |  | 8 | 

         | groupname1 |  | 4 | 

         | groupname0 |  | 3 | 

         | groupname2 |  | 1 | 
        ____________________________________


----------


 * Выдать список ФИО персон, в котором для каждой персоны указано количество групп, в которые она входит, упорядоченный по убыванию количества групп  

     	 | People |  | GroupsCount | 
        ____________________________________
         | name17 surname17 secondName17 |  | 3 | 

         | name4 surname4 secondName4 |  | 3 | 

         | name10 surname10 secondName10 |  | 2 | 

         | name2 surname2 secondName2 |  | 2 | 

         | name1 surname1 secondName1 |  | 2 | 

         | name14 surname14 secondName14 |  | 2 | 

         | name5 surname5 secondName5 |  | 2 | 

         | name11 surname11 secondName11 |  | 2 | 

         | name8 surname8 secondName8 |  | 1 | 

         | name7 surname7 secondName7 |  | 1 | 

         | name15 surname15 secondName15 |  | 1 | 

         | name6 surname6 secondName6 |  | 1 | 

         | name9 surname9 secondName9 |  | 1 | 

         | name12 surname12 secondName12 |  | 1 | 

         | name3 surname3 secondName3 |  | 1 | 

         | name18 surname18 secondName18 |  | 1 | 

         | name16 surname16 secondName16 |  | 0 | 

         | name0 surname0 secondName0 |  | 0 | 

         | name13 surname13 secondName13 |  | 0 | 

         | name19 surname19 secondName19 |  | 0 | 
        ____________________________________


----------


* Выдать общее количество групп, в которых состоят друзья друзей персоны с заданными ФИО ("name1 surname1 secondName1")

    	 | FriendOfFriendGroupsCount | 
        ____________________________________
         | 223 | 
        ____________________________________


----------



* Вывести список записей персоны с заданными ФИО ("name1 surname1 secondName1")

    	 | PersonTweets | 
        ____________________________________
         | tweet0 | 

         | tweet1 | 

         | tweet2 | 
        ____________________________________


----------
	

* Вывести список средних длин записи для каждого пользователя, отсортированный по убыванию средней длины

    	 | AverageTweetLength |  | People | 
        ____________________________________
         | 6.29 |  | name19 surname19 secondName19 | 

         | 6.23 |  | name4 surname4 secondName4 | 

         | 6.23 |  | name11 surname11 secondName11 | 

         | 6.0 |  | name17 surname17 secondName17 | 

         | 6.0 |  | name8 surname8 secondName8 | 

         | 6.0 |  | name10 surname10 secondName10 | 

         | 6.0 |  | name7 surname7 secondName7 | 

         | 6.0 |  | name2 surname2 secondName2 | 

         | 6.0 |  | name1 surname1 secondName1 | 

         | 6.0 |  | name16 surname16 secondName16 | 

         | 6.0 |  | name15 surname15 secondName15 | 

         | 6.0 |  | name6 surname6 secondName6 | 

         | 6.0 |  | name0 surname0 secondName0 | 

         | 6.0 |  | name14 surname14 secondName14 | 

         | 6.0 |  | name5 surname5 secondName5 | 

         | 6.0 |  | name13 surname13 secondName13 | 

         | 6.0 |  | name9 surname9 secondName9 | 

         | 6.0 |  | name12 surname12 secondName12 | 

         | 6.0 |  | name3 surname3 secondName3 | 

         | 6.0 |  | name18 surname18 secondName18 | 
        ____________________________________


----------


* Вывести все записи в социальной сети, длиннее некоторой величины (>6)

     	 | Tweets | 
        ____________________________________
         | tweet10 | 

         | tweet10 | 

         | tweet10 | 

         | tweet11 | 

         | tweet11 | 

         | tweet11 | 

         | tweet12 | 

         | tweet12 | 

         | tweet12 | 

         | tweet13 | 
        ____________________________________


----------


* Выдать список ФИО персон, в котором для каждой персоны указано количество записей данной персоны, упорядоченный по убыванию количества записей

     	 | TweetsCount |  | People | 
        ____________________________________
         | 14 |  | name19 surname19 secondName19 | 

         | 13 |  | name4 surname4 secondName4 | 

         | 13 |  | name11 surname11 secondName11 | 

         | 10 |  | name16 surname16 secondName16 | 

         | 10 |  | name15 surname15 secondName15 | 

         | 10 |  | name14 surname14 secondName14 | 

         | 9 |  | name9 surname9 secondName9 | 

         | 9 |  | name3 surname3 secondName3 | 

         | 7 |  | name17 surname17 secondName17 | 

         | 6 |  | name8 surname8 secondName8 | 

         | 6 |  | name10 surname10 secondName10 | 

         | 6 |  | name18 surname18 secondName18 | 

         | 5 |  | name7 surname7 secondName7 | 

         | 3 |  | name1 surname1 secondName1 | 

         | 3 |  | name0 surname0 secondName0 | 

         | 3 |  | name12 surname12 secondName12 | 

         | 2 |  | name2 surname2 secondName2 | 

         | 2 |  | name5 surname5 secondName5 | 

         | 1 |  | name6 surname6 secondName6 | 

         | 1 |  | name13 surname13 secondName13 | 
        ____________________________________


----------


* Вывести все записи друзей друзей персоны с заданными ФИО ("name1 surname1 secondName1")

     	 | DeepFriendTweets | 
        ____________________________________
         | tweet0 | 
        ---------------+1017+---------------
         | tweet9 | 
        ____________________________________