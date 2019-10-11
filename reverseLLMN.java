import java.util.*;
 
 public class reverseLLMN {
 
     // -----------------------------------------------------
     // This is a functional problem. Only this function has to be written.
     // This function takes as input the head of the linked list, m and n.
     // It should return the head of the modified list.
 
     public static Node reverseBetween(Node head, int m, int n) {
         // write your code here
         
         if(head == null || head.next == null)
         {
             return head;
         }
         if(head.next.next == null)
         {
             if(m==1 && n==2)
             {
                 head.next.next = head;
                 head.next = null;
                 return head;
             }
             else
             {
                 return head;
             }
         }
         Node prev = head,cur = head.next,nxt = head.next.next;
         int c = 1;
         Node savepprev = null;
         while(cur!=null)
         {
             Node saveprev = prev;
             if(c == m)
             {
                while(c<n)
                {
                    cur.next = prev;
                    prev = cur;
                    cur = nxt;
                    if(nxt == null)
                    {
                        break;
                    }
                    nxt = nxt.next;
                    c++;
                }
                if(savepprev != null)
                {
                    savepprev.next = prev;
                    saveprev.next = cur;
                }
                else
                {
                    head = prev;
                    saveprev.next = cur;
                }
                break;
             }
             else if(c < m)
             {
                 c++;
                 savepprev = prev;
                 prev = cur;
                 cur = nxt;
                 nxt = nxt.next;
             }
         }
         return head;
     }
 
     // -----------------------------------------------------
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n1 = sc.nextInt();
         int a1 = sc.nextInt();
         head1 = insert(head1, a1);
 
         for (int i = 1; i < n1; i++) {
             int a = sc.nextInt();
             head1 = insert(head1, a);
         }
 
         int m = sc.nextInt();
         int n = sc.nextInt();
         head1 = reverseBetween(head1, m, n);
         display(head1);
 
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
 
     static Node head1;
 
     static Node head2;
 
     static Node head3;
 
     /*
      * Input Parameters: head: head of the linked list in which a new node is to
      * be inserted. data: the data value of the node which is to be inserted.
      * 
      * Return Value: head of the linked list in which the node is inserted
      */
     public static Node insert(Node head, int data) {
 
         if (head == null) {
             return new Node(data);
         }
 
         head.next = insert(head.next, data);
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
             System.out.print(node.data + " ");
         }
     }
 
 }