// Java program to demonstrate 
// size() method of Collection 
import java.util.*; 
import java.io.*; 

class Example2 { 
	public static void main(String[] args) 
	{ 

		// Creating object of LinkedList<Integer> 
		LinkedList<String> al = new LinkedList<String>(); 

		// Populating LinkedList 
		al.add("GEEKS"); 
		al.add("FOR"); 
		al.add("GEEKS"); 

		// getting total size of Linkedlist 
		// using size() method 
		int size = al.size(); 

		// print the size 
		System.out.println("Size of the linkedlist = "
						+ size); 

		// print Linkedlist 
		System.out.println("Linkedlist = " + al); 
	} 
}
