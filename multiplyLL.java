import java.util.*;
 
 public class multiplyLL {
 
     // -----------------------------------------------------
     // This is a functional problem. You have to complete this function.
     // It takes as input the head of the two lists.
     // It returns the product of two lists.
     
     public static Node reverseLL(Node head)
      {
          if(head == null || head.next == null)
          {
              return head;
          }
          Node prev = head,cur = head.next;
          while(cur !=null)
          {
              Node tmp = cur.next;
              cur.next = prev;
              prev = cur;
              cur = tmp;
          }
          head.next = null;
          return prev;
      }
 
 
   
 	 public static Node addTwoNumbers(Node n1, Node n2) {
 	     Node tmp1 = n1,tmp2 = n2;
 	     int dig = 0;
 	     int carry = 0;
 	     Node h2 = null,t2 = null;
 	     while(tmp1!=null && tmp2!=null)
 	     {
 	         dig = (tmp1.data + tmp2.data + carry)%10;
 	         carry = (tmp1.data + tmp2.data + carry)/10;
 	         Node newNode = new Node(dig);
 	         if(h2 == null)
             {
                h2 = newNode;
                t2 = newNode;
             }
             else
             {
                t2.next = newNode;
                t2 = t2.next;
             }
             tmp1 = tmp1.next;
             tmp2 = tmp2.next;
 	     }
 	     
 	     while(tmp1!=null)
 	     {
 	         dig = (tmp1.data + carry)%10;
 	         carry = (tmp1.data + carry)/10;
 	         Node newNode = new Node(dig);
 	         if(h2 == null)
             {
                h2 = newNode;
                t2 = newNode;
             }
             else
             {
                t2.next = newNode;
                t2 = t2.next;
             }
             tmp1 = tmp1.next;
 	     }
 	     
 	     while(tmp2!=null)
 	     {
 	         dig = (tmp2.data + carry)%10;
 	         carry = (tmp2.data + carry)/10;
 	         Node newNode = new Node(dig);
 	         if(h2 == null)
             {
                h2 = newNode;
                t2 = newNode;
             }
             else
             {
                t2.next = newNode;
                t2 = t2.next;
             }
             tmp2 = tmp2.next;
 	     }
 	     
 	     if(carry!=0)
 	     {
 	         Node newNode = new Node(carry);
 	         if(h2 == null)
             {
                h2 = newNode;
                t2 = newNode;
             }
             else
             {
                t2.next = newNode;
                t2 = t2.next;
             }
 	     }
 	     h2 = reverseLL(h2);
 	     return h2;
 	 }
     
     
     public static Node addLast(Node tail,int data)
     {
         Node newNode = new Node(data);
         if(tail == null)
         {
             tail = newNode;
             return tail;
         }
         tail.next = newNode;
         tail = tail.next;
         return tail;
     }
     
     public static long multiplyTwoLists(Node one, Node two) {
         // write your code here.
         one = reverseLL(one);
         two = reverseLL(two);
         Node temp1 = one;
         Node temp2 = two;
         Node sum = null;
         int zeroes = 0;
         while(temp2!=null)
         {
             temp1 = one;
             
             Node ph = null,pt = null;
             for(int i = 0;i<zeroes;++i)
             {
                 if(pt == null)
                 {
                     ph = addLast(pt,0);
                     pt = ph;
                 }
                 else
                 {
                     pt = addLast(pt,0);
                 }
             }
//             display(pt);
//             System.out.println();
             int carry = 0;
             while(temp1 != null)
             {
                 int dig = (temp1.data*temp2.data + carry)%10;
                 carry = (temp1.data*temp2.data + carry)/10;
//                 System.out.println(dig + " " + carry);
                 if(pt == null)
                 {
                     ph = addLast(pt,dig);
                     pt = ph;
                 }
                 else
                 {
                     pt = addLast(pt,dig);
                 }
                 temp1 = temp1.next;
             }
             if(carry != 0)
             {
                 pt = addLast(pt,carry);
             }
             if(sum == null)
             {
                 display(ph);
                 System.out.println();
                 sum = ph;
             }
             else
             { 
                 display(sum);
                 System.out.println();
                 display(ph);
                 System.out.println();
                 sum = addTwoNumbers(sum,ph);
                 sum = reverseLL(sum);
             }
             temp2 = temp2.next;
             zeroes++;
         }
        sum = reverseLL(sum);
        long ans = 0;
        while(sum != null)
        {
            ans = (((ans%1000000007)*10)%1000000007 + sum.data)%1000000007;
            sum = sum.next;
        }
        return ans;
        
        
     }
 
     // -----------------------------------------------------
 
     static Node head1;
 
     static Node head2;
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n1 = sc.nextInt();
         int a1 = sc.nextInt();
 
         Node tail;
         head1 = tail = insert(null, a1);
 
         for (int i = 1; i < n1; i++) {
             int a = sc.nextInt();
             tail = insert(tail, a);
         }
 
         int n2 = sc.nextInt();
         int a2 = sc.nextInt();
 
         head2 = tail = insert(null, a2);
 
         for (int i = 1; i < n2; i++) {
             int a = sc.nextInt();
             tail = insert(tail, a);
         }
 
         System.out.println(multiplyTwoLists(head1, head2));
 
     }
 
     // Class declaration for a Node of the Linked List
     static class Node {
         int data;
         Node next;
 
         public Node(int data) {
             this.data = data;
             this.next = null;
         }
 
     }
 
     /*
      * Input Parameters: tail: head of the linked list in which a new node is to
      * be inserted. data: the data value of the node which is to be inserted.
      * 
      * Return Value: tail of the linked list/the node that is inserted
      */
     public static Node insert(Node tail, int data) {
 
         if (tail == null) {
             return new Node(data);
         }
 
         Node nn = new Node(data);
         tail.next = nn;
         return nn;
     }
 
     /*
      * Input Parameters: head: head of the linked list in which is to be
      * displayed.
      * 
      * Return Value: null
      */
     public static void display(Node head) {
         for (Node node = head; node != null; node = node.next) {
             System.out.print(node.data + " ");
         }
     }
 
 }