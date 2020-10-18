// Java code to illustrate boolean addAll() 

import java.util.*; 
import java.util.*; 

public class LinkedListDemo { 
	public static void main(String args[]) 
	{ 

		// Creating an empty LinkedList 
		Collection<String> 
			list = new LinkedList<String>(); 

		// A collection is created 
		Collection<String> 
			collect = new LinkedList<String>(); 
		collect.add("A"); 
		collect.add("Computer"); 
		collect.add("Portal"); 
		collect.add("for"); 
		collect.add("Geeks"); 

		// Displaying the list 
		System.out.println("The LinkedList is: " + list); 

		// Appending the collection to the list 
		list.addAll(collect); 

		// displaying the modified LinkedList 
		System.out.println("The new linked list is: "
						+ list); 
	} 
} 
