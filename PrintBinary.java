import java.util.*;
public class PrintBinary {

	public static void getBinary(int n){
	        //write your code here
	    Queue<String> q = new LinkedList<>();
	    q.add("1");
	    int c = 1;
	    while(q.size()!=0)
	    {
	        String str = q.poll();
	        System.out.print(str + " ");
	        if(2*c <= n)
	            q.add(str+'0');
	        if(2*c + 1 <= n)
	            q.add(str+'1');
	        c++;
	    }
	    return;
	     }
	 	 public static void main (String[] args)  {
	 	     
	 	 Scanner scn=new Scanner(System.in);
	 	  int n = scn.nextInt();
	 	  getBinary(n);
	 	         
	 	     
	 	 }
}
