import java.io.*;
import java.util.*;

public class temp {

    static class Node{
        int data;
        Node next;
        
        Node(int d)
        {
            this.data = d;
        }
    }
    
    public static void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data + " ");
            head=  head.next;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner s  = new Scanner(System.in);
        int N = s.nextInt();
        int k = s.nextInt();
        Node head = null,tail = null;
        for(int i = 0;i<N;++i)
        {
            Node newNode = new Node(s.nextInt());
            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        if(k == N - k + 1 || N < k)
        {
            display(head);
            return;
        }
        int c1 = 1;
        Node t1 = head;
        Node t2 = head;
        while(t2!=null && c1 < N - k +1)
        {
            if(c1 == k)
            {
                t1 = t2;
            }
            c1++;
            t2 = t2.next;
        }
        int tmp = t1.data;
        t1.data = t2.data;
        t2.data = tmp;
        display(head);

    }
}