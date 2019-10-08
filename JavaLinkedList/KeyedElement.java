/*
Author: Marshal
KeyedElement class stores the methods used to create a LinkedList

*/

public class KeyedElement
{
   //key is index location
   public int key;
   //payload is an object value stored
   public Integer payLoad;
   //next iterates to next element in linked list
   public KeyedElement next;

   
   public KeyedElement(int key, Integer value)
   {
      this.key = key;
      
      payLoad = value;
      next = null;

   }
   

   int getKey(){return key;}

   Integer getPayload() {return payLoad;}

   KeyedElement getNext() {return next;}

   void setNext(KeyedElement next) {this.next = next;}

   boolean isKey(int value)
   {
      if (key == value) return true;
      else return false;
   }
   
   
}