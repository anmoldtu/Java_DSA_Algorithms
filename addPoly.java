import java.util.*;
 
 public class addPoly {
 
     // Class declaration for a Node of the Linked List
     static class Node {
         int coeff;
         int pow;
         Node next;
 
         Node(int a, int b) {
             coeff = a;
             pow = b;
             next = null;
         }
 
     }
 
     // -----------------------------------------------------
     // This is a functional problem. Only this function has to be written.
     // This function takes as input the head of two linked lists representing
     // two polynomial numbers.
     // Print the polynomial formed by adding both LL in the function itself.
 
     public static void addPolynomial(Node poly1, Node poly2) {
         // write your code here
         // Print the polynomial formed by adding both LL in the function itself.
         
         Node poly3head = null,poly3tail=null;
         while(poly1 != null && poly2 != null)
         {
             if(poly1.pow == poly2.pow)
             {
                 Node newNode = new Node(poly1.coeff + poly2.coeff,poly1.pow);
                 if(poly3head == null)
                 {
                     poly3head = newNode;
                     poly3tail = newNode;
                 }
                 else
                 {
                	 	poly3tail.next = newNode;
                	 	poly3tail = poly3tail.next;
                 }
                 poly1 = poly1.next;
                 poly2 = poly2.next;
             }
             else if(poly1.pow < poly2.pow)
             {
                 Node tmp = poly1.next;
                 poly1.next = null;
                 if(poly3head == null)
                 {
                     poly3head = poly1;
                     poly3tail = poly1;
                 }
                 else
                 {
                     poly3tail.next = poly1;
             	 	 poly3tail = poly3tail.next;

                 }
                 poly1 = tmp;
             }
             else
             {
                 Node tmp = poly2.next;
                 poly2.next = null;
                 if(poly3head == null)
                 {
                     poly3head = poly2;
                     poly3tail = poly2;
                 }
                 else
                 {
                     poly3tail.next = poly2;
             	 	 poly3tail = poly3tail.next;

                 }
                 poly2 = tmp;
             }
         }
         while(poly1 != null)
         {
        	 	Node tmp = poly1.next;
             poly1.next = null;
             if(poly3head == null)
             {
                 poly3head = poly1;
                 poly3tail = poly1;
             }
             else
             {
                 poly3tail.next = poly1;
         	 	 poly3tail = poly3tail.next;

             }
             poly1 = tmp;
         }
         while(poly2 != null)
         {
        	 	Node tmp = poly2.next;
             poly2.next = null;
             if(poly3head == null)
             {
                 poly3head = poly2;
                 poly3tail = poly2;
             }
             else
             {
                 poly3tail.next = poly2;
         	 	 poly3tail = poly3tail.next;

             }
             poly2 = tmp;
         }
         
         display(poly3head);
         return;
     }
 
     //
 
     // -----------------------------------------------------
 
     static Node head;
 
     static Node head2;
 
     static Node head3;
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int a1 = sc.nextInt();
         int b1 = sc.nextInt();
         head = insert(head, a1, b1);
 
         for (int i = 1; i < n; i++) {
             int a = sc.nextInt();
             int b = sc.nextInt();
             head = insert(head, a, b);
         }
 
         int n2 = sc.nextInt();
         int a2 = sc.nextInt();
         int b2 = sc.nextInt();
         head2 = insert(head2, a2, b2);
 
         for (int i = 1; i < n2; i++) {
             int a = sc.nextInt();
             int b = sc.nextInt();
             head2 = insert(head2, a, b);
         }
         display(head);
         display(head2);
         addPolynomial(head, head2);
     }
 
     /*
      * Input Parameters: head: head of the linked list in which a new node is to
      * be inserted. data: the data value of the node which is to be inserted.
      * 
      * Return Value: head of the linked list in which the node is inserted
      */
     public static Node insert(Node head, int a, int b) {
 
         if (head == null) {
             return new Node(a, b);
         }
 
         head.next = insert(head.next, a, b);
 
         return head;
     }
 
     /*
      * Input Parameters: head: head of the linked list in which is to be
      * displayed.
      * 
      * Return Value: null
      */
     public static void display(Node head) {
         for (Node node = head; node != null; node = node.next) {
             System.out.print(node.coeff + "x^" + node.pow + " ");
         }
         System.out.println();
     }
 
 }