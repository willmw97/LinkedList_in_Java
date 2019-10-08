/*
Author: Marshal Will
Program Description:
Program will generate random numbers between 0 and 100 inclusive.
While creating the random numbers the program will repeat 25 times
and create it in 25 in length.
Then it will call methods in class LinkedList to find and remove 
each value that is randomly generated.

*/

import java.util.Random;

public class mainList
{
   public static void main(String[] args)
   {
      //Random method object imported
      Random random = new Random();
      //object list for linked list creates
      LinkedList list = new LinkedList();
      //for loop will generate 25 random numbers 
      for(int i=0; i<=25;i++)
      {
         //random numbers are generated between 0 and 100
         int randomInteger = random.nextInt(101);
         while(list.find(randomInteger)==false)//while prevents repeat values
         {
            //random integer is also inserted
            Integer value = new Integer(randomInteger);
            list.addStart(randomInteger, value);
         }
         
      
      }
      System.out.println("Unsorted Random List");
      System.out.println(list.toString());
      list.sort();//sorts values from least to greatest
      System.out.println("Sorted Random List");
      System.out.println(list.toString());//prints sorted list
      System.out.println("Start of Removing List");
      
      //for loop will remove each "key" and "payLoad"
      for(int i=0; i<list.size(); i++)
      {  
         while(list.size() >=0)//runs until list is empty
         {
            int randomInteger = random.nextInt(101);
            if(list.find(randomInteger)==true)//checks if random number is in linked list
            {
               int myIndex = list.indexOf(randomInteger);//finds the index of random number
               list.remove(myIndex);//removes number based on the index location
               System.out.println(list.toString());//prints new linked list
               System.out.println("List Size Remaining is: "+list.size()+ " and the number that was removed was "+ randomInteger);
            }
            //breaks out of while once list is empty
            if(list.size() == 0)
               break;
         }
      
      }
      
   }


}