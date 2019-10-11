import java.util.Scanner;

public class kStacks {

	
	static class stack {
		int darr[];
		int parr[];
		int shead[];
		int freehead;
		
		public stack(int size,int k)
		{
			parr = new int[size];
			darr = new int[size];
			shead = new int[k];
			for(int i = 0;i<parr.length-1;++i)
			{
				parr[i] = i+1;
			}
			parr[parr.length-1] = -1;
			for(int i = 0;i<shead.length;++i)
			{
				shead[i] = -1;
			}
			freehead = 0;
		}
		
		public void push(int sno,int x)
		{
			if(isFull())
			{
				return;
			}
			int temp = freehead;
			freehead = parr[freehead];
			parr[temp] = shead[sno];
			shead[sno] = temp;
			darr[shead[sno]] = x; 
		}
		
		public int pop(int sno)
		{
			if(isEmpty(sno))
			{
				return -1;
			}
			int val = darr[shead[sno]];
			int tmp = parr[shead[sno]];
			parr[shead[sno]] = freehead;
			freehead = shead[sno];
			shead[sno] = tmp;
			return val;
		}
		
		public boolean isFull()
		{
			if(parr[freehead] == -1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean isEmpty(int sno)
		{
			if(shead[sno] == -1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public int top(int sno)
		{
			if(shead[sno] == -1)
			{
				return -1;
			}
			else
			{
				return darr[shead[sno]];
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int size = s.nextInt();
		stack sta = new stack(size,k);
		while(true)
		{
			int choice = s.nextInt();
			if(choice == 0)
			{
				int sno = s.nextInt();
				int x = s.nextInt();
				sta.push(sno, x);
			}
			if(choice == 1)
			{
				int sno = s.nextInt();
				System.out.println(sta.pop(sno));
			}
			if(choice == 2)
			{
				int sno = s.nextInt();
				System.out.println(sta.top(sno));
			}
			if(choice == 3)
			{
				System.out.println(sta.isFull());
			}
			if(choice == 4)
			{
				int sno = s.nextInt();
				System.out.println(sta.isEmpty(sno));
			}
			if(choice == 5)
			{
				break;
			}
		}
		
		
	}

}
