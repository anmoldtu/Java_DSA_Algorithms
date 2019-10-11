import java.util.*;
 
public class CirDeque {
     
     static class Node{
         int data;
         Node next;
         Node prev;
         
         Node(int d)
         {
             this.data = d;
             this.next = null;
             this.prev = null;
         }
     }
     
     static class CircularDeque {
 
         Node head;
         Node tail;
         public int size;
         int capacity;
 
         public CircularDeque(int k) {
        	 	head = null;
        	 	tail = null;
        	 	capacity = k;
        	 	size = 0;
         }
 
         public boolean insertFront(int value) {
	        	 if(isFull())
	    		 {
	    			 return false;
	    		 }   	 
	        	 if(head == null)
	        	 {	 
	        		 Node newNode = new Node(value);
	        		 head = newNode;
	        		 tail = newNode;
	        		 head.next = head;
	        		 head.prev = head;
	        		 size++;
	        	 }
	        	 else
	        	 {
	        		 Node newNode = new Node(value);
	        		 newNode.next = head;
	        		 head.prev = newNode;
	        		 head = newNode;
	        		 head.prev = tail;
	        		 tail.next = head;
	        		 size++;
	        	 }
	        	 return true;
         }
 
         public boolean insertLast(int value) {
	        	 if(isFull())
	    		 {
	    			 return false;
	    		 }   	 
	        	 if(tail == null)
	        	 {	 
	        		 Node newNode = new Node(value);
	        		 head = newNode;
	        		 tail = newNode;
	        		 size++;
	        	 }
	        	 else
	        	 {
	        		 Node newNode = new Node(value);
	        		 tail.next = newNode;
	        		 newNode.prev = tail;
	        		 tail = newNode;
	        		 tail.next = head;
	        		 head.prev = tail;
	        		 size++;
	        	 }
	        	 return true;
         }
 
         public boolean deleteFront() {
        	 	if(isEmpty())
        	 	{
        	 		return false;
        	 	}
        	 	if(!head.equals(head.next))
        	 	{
        	 		head = head.next;
            	 	tail.next = head;
            	 	head.prev = tail;
            	 	
        	 	}
        	 	else
        	 	{
        	 		tail = null;
        	 		head = null;
        	 	}
        	 	size--;
        	 	return true;
        	 	
         }
 
         public boolean deleteLast() {
        	 	if(isEmpty())
     	 	{
     	 		return false;
     	 	}
        	 	if(!tail.equals(tail.prev))
        	 	{
        	 		tail = tail.prev;
         	 	tail.next = head;
         	 	head.prev = tail;
        	 	}
        	 	else
        	 	{
        	 		tail = null;
        	 		head = null;
        	 	}
     	 	size--;
     	 	return true;
         }
 
         public int getFront() {
        	 	if(isEmpty())
      	 	{
      	 		return -1;
      	 	}
        	 	else
        	 	{
        	 		return head.data;
        	 	}
         }
 
         public int getRear() {
        	 if(isEmpty())
       	 	{
       	 		return -1;
       	 	}
     	 	else
     	 	{
     	 		return tail.data;
     	 	}
         }
 
         public boolean isEmpty() {
        	 	if(size == 0)
        	 	{
        	 		return true;
        	 	}
        	 	else
        	 	{
        	 		return false;
        	 	}
         }
 
         public boolean isFull() {
        	 	if(size == capacity)
        	 	{
        	 		return true;
        	 	}
        	 	else
        	 	{
        	 		return false;
        	 	}
         }
 
     }
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         CircularDeque cd = new CircularDeque(sc.nextInt());
         int n = sc.nextInt();
         for (int i = 0; i < n; i++) {
             int q = sc.nextInt();
             String s = "";
             if (q == 1) {
                 s = "" + cd.insertFront(sc.nextInt());
             } else if (q == 0) {
                 s = "" + cd.insertLast(sc.nextInt());
             } else if (q == 2) {
                 s = "" + cd.deleteFront();
             } else if (q == -2) {
                 s = "" + cd.deleteLast();
             } else if (q == 3) {
                 s = "" + cd.getFront();
             } else if (q == -3) {
                 s = "" + cd.getRear();
             } else if (q == 4) {
                 s = "" + cd.isEmpty();
             } else if (q == 5) {
                 s = "" + cd.isFull();
             }
             System.out.print(s + " ");
         }
 
     }
 
 }