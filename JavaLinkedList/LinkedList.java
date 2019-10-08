
/*
Author: Marshal Will
LinkedList class stores all methods for adjusting a LinkedList in Java

*/
public class LinkedList
{
   //Sets the first Element
   public KeyedElement firstElement;
   //Sets global size of 
   public int size;
	public LinkedList()
	{
      size = 0; //global size
		firstElement = null; //firstElement is null in linked list
   
   }
   //Adding Method
   public void addStart(int index, int payLoad)
   {
      //creates a new node and payload for linked list
      KeyedElement current = new KeyedElement(index, payLoad);
      current.setNext(firstElement);//sets the next element
      firstElement = current;//the next element "null" is set in the linked list
   }
   //Find given key
   //Returns true or false if value is in the list
	public boolean find(int value) 
   {
		KeyedElement e = firstElement;
		//while e is not null will check if available
		while( e != null)
		{
		   if (e.isKey(value))
		   {
			   return true;//returns true if key is found
			}
				e = e.getNext(); //move to the next 
		}
      return false;        		
	}

   //PeekKeyed
   //Precondition: 0 <= index < size
   //Removes the element at the specific index value thats passed
   public void remove(int index) 
   {
      if (index == 0) //if no index values then next is firstElement
      {
         firstElement = firstElement.next;
      } 
      else // sets the next current value and removes current one
      {
         KeyedElement current = firstElement;
         for(int i = 0; i < index - 1; i++) 
         {
            current = current.next;
         }
         current.next = current.next.next;
      }   	
   }
   //returns the element at the specific index value thats passed
   public int get(int index)
	{
	   //index must be 1 or higher
		if(index<=0)
			return -1;
		
		KeyedElement current = firstElement.getNext();
		for(int i=1; i<index; i++)//runs through linked list until specified
		{
			if(current.getNext()==null)
				return -1;
			current=current.next;
		}
		return current.getPayload();
	}
   //returns the index element based on the index value thats passed
   public int indexOf(int myindex) 
   {
      int index = 0;
      KeyedElement current = firstElement;
      //runs while the first element is not null
      while (current != null) 
      {
         if (current.payLoad.equals(myindex))//returns index location once value is found 
         {
            return index;
         }
         index++;//cycles through index
         current = current.next;//sets the current value
      }
      return -1;
   }
     
   //returns size of linked list
	public int size() 
   {
		int count = 0;
		
		KeyedElement e = firstElement;
      //while element is null, counts length of linked list
		while (e != null)
		{
			++ count;
			e = e.getNext();
		}
		//return total size
		return count;
	}
	
   //OrderedKey
   //sorts all the elements in linked list using bubble algorithm
   public void sort() 
   {
      boolean wasChanged;
      do 
      {          
         KeyedElement current = firstElement;//set current element
         KeyedElement previous = null;//previous is null
         KeyedElement next = firstElement.getNext();//sets next element after current
         wasChanged = false;

         while ( next != null ) 
         {
            if (current.getKey() > next.getKey()) //if one index is larger then other run
            {
               wasChanged = true;//return true for while

               if ( previous != null ) //if prev. is not null then set next
               {
                  KeyedElement sig = next.next;//will get the next element after next
                  previous.next = next;//shifts previous forward
                  next.next = current;//shifts currents
                  current.next = sig;//shifts current forward
                } 
                else 
                {
                  KeyedElement sig = next.next;
                  firstElement = next;//changes so the next element is first
                  next.next = current;//current is now next
                  current.next = sig;
                }
                  previous = next;
                  next = current.next;
              } 
              else
              { 
               previous = current;//prev is now current
               current = next;//shifts forward the current
               next = next.next;    
               }
              } 
            } while( wasChanged );
        }
      //prints out all the keys and payload of each list element
   public String toString() 
   {
      if (firstElement == null) 
      {
         return "[]";
      } 
      else 
      {
         //prints the "key" and the coresponding "payLoad" in linked list
         String result = "[" + firstElement.key + "-" + firstElement.payLoad;
         KeyedElement e = firstElement.next;
         //cycles through list to print result of both "key" and "payLoad"
         while (e != null) 
         {
            result += ", " + e.key + "-" + e.payLoad;
            e = e.next;  
         }
         result += "]";
         return result;
      }
   } 
   
}