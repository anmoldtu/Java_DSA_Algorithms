// Java code to illustrate boolean addAll() 

import java.util.*; 

public class LinkedListDemo { 
	public static void main(String args[]) 
	{ 

		// Creating an empty ArrayList 
		Collection<String> 
			list = new ArrayList<String>(); 

		// A collection is created 
		Collection<String> 
			collect = new ArrayList<String>(); 
		collect.add("A"); 
		collect.add("Computer"); 
		collect.add("Portal"); 
		collect.add("for"); 
		collect.add("Geeks"); 

		// Displaying the list 
		System.out.println("The ArrayList is: " + list); 

		// Appending the collection to the list 
		list.addAll(collect); 

		// displaying the modified ArrayList 
		System.out.println("The new ArrayList is: "
						+ list); 
	} 
} 
