import java.util.*;
 
 public class AlternativelyMerge {
 
     // -----------------------------------------------------
     // This is a functional problem. Only this function has to be written.
     // This takes as input the heads of first and second linked list.
     // It should return an array containing containing heads of resultant
     // first and second linked list at index 0 and 1 respectively.
     public static Node[] mergeAlt(Node head1, Node head2){
         //write your code here, and print the result
         Node[] arr = new Node[2];
         if(head1 == null || head2 == null)
         {
             arr[0] = head1;
             arr[1] = head2;
             return arr;
         }
         
         Node temp1 = head1,temp1next = head1.next;
         Node temp2 = head2,temp2next = head2.next;
         while(temp1 != null && temp2!=null)
         {
             temp1.next = temp2;
             temp2.next = temp1next;
             temp1 = temp1next;
             temp2 = temp2next;
             if(temp1next!=null && temp2next!=null)
             {
                 temp1next = temp1next.next;
                 temp2next = temp2next.next;
             }
         }
         display(head1);
         display(temp2);
         arr[0] = head1;
         arr[1] = temp2;
         return arr;
         
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
 
         int n2 = sc.nextInt();
         int a2 = sc.nextInt();
         head2 = insert(head2, a2);
 
         for (int i = 1; i < n2; i++) {
             int a = sc.nextInt();
             head2 = insert(head2, a);
         }
         Node[] res = mergeAlt(head1, head2);
         display(res[0]);
         display(res[1]);
         //head3 = sublinkedList(head, head2);
         //display(head3);
 
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
         System.out.println();
     }
 
 }