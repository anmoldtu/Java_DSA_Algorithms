import java.util.*;
public class LRUCache {

	static class Node {
		int data;
		int key;
		Node prev;
		Node next;
		
		public Node(int key,int data)
		{
			this.data = data;
			this.prev = null;
			this.next = null;
			this.key = key;
		}
	}
	
	static class LRU {
		Node head;
		Node tail;
		HashMap<Integer,Node> map;
		int capacity;
		
		public LRU(int capacity)
		{
			head = null;
			tail = null;
			map = new HashMap<>();
			this.capacity = capacity;
		}
		
		public int get(int k)
		{
			if(map.containsKey(k))
			{
				Node n = map.get(k);
				if(n == head)
				{
					return n.data;
				}
				else
				{
					if(capacity == 1)
					{
						return head.data;
					}
					n.prev.next = n.next;
					if(n.next == null)
					{
						tail = n.prev;
					}
					else
					{
						n.next.prev = n.prev;
					}
					n.next = head;
					head.prev = n;
					n.prev = null;
					head = n;
					return head.data;
				}
			}
			else
			{
				return -1;
			}
		}
		
		public void set(int k,int x)
		{
			if(map.containsKey(k))
			{
				Node n = map.get(k);
				if(n == head)
				{
					n.data = x;
				}
				else
				{
					n.prev.next = n.next;
					if(n.next == null)
					{
						tail = n.prev;
					}
					else
					{
						n.next.prev = n.prev;
					}
					n.next = head;
					head.prev = n;
					n.prev = null;
					head = n;
					head.data = x;
				}
			}
			else
			{
				Node newNode = new Node(k,x);
				if(map.size() == capacity)
				{
					if(capacity == 1) {
						int key = tail.key;
						map.remove(key);
						head = null;
						tail = null;
					}
					else
					{
						tail.prev.next = null;
						int key = tail.key;
						tail = tail.prev;
						map.remove(key);
					}
					
				}
				if(head == null)
				{
					head = newNode;
					tail = newNode;
				}
				else
				{
					newNode.next = head;
					head.prev = newNode;
					head = newNode;
				}
				map.put(k, newNode);
				
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LRU LRUobj = new LRU(5);
		System.out.println(LRUobj.get(0));
		LRUobj.set(0 ,100);
		LRUobj.set(1 ,200);
		System.out.println(LRUobj.get(0));
		System.out.println(LRUobj.get(1));
		LRUobj.set(0 ,1000);
		System.out.println(LRUobj.get(0));
		LRUobj.set(2 ,300);
		LRUobj.set(3 ,400);
		LRUobj.set(4 ,500);
		LRUobj.set(5 ,600);
		System.out.println(LRUobj.get(1));
		System.out.println(LRUobj.get(0));
		Node tmphead = LRUobj.head;
		System.out.println();
		while(tmphead!=null)
		{
			System.out.println(tmphead.data);
			tmphead = tmphead.next;
		}
		System.out.println();
		System.out.println(LRUobj.tail.data);
	}

}
