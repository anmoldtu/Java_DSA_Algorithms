import java.util.*;
public class NextWarmerDay {
	 public static int[] findWarmerTemp(int T[]){
		 // Write your code here only
		          Stack<ArrayList<Integer>> s = new Stack();
		          ArrayList<Integer> temp = new ArrayList<Integer>();
		          temp.add(T[T.length-1]);
		          temp.add(T.length-1);
		      	  s.push(temp);
		      	  int nge[] = new int[T.length];
		      	  nge[T.length-1] = 0;
		      	  for(int i = T.length-2;i>=0;--i)
		      	  {
		      	      while(!s.empty() && s.peek().get(0) < T[i])
		      	      {
		      	          s.pop();
		      	      }
		      	      if(s.empty())
		      	      {
		      	          nge[i] = 0;
		      	      }
		      	      else
		      	      {
		      	          nge[i] = s.peek().get(1) - i;
		      	      }
		      	      ArrayList<Integer> t2 = new ArrayList<Integer>();
		              t2.add(T[i]);
		              t2.add(i);
		      	      s.push(t2);
		      	  }
		      	  return nge;
		 }
		  
		 
		 // Dont make changes here
		 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);  
		 int n=sc.nextInt();
		 int temp[]=new int[n];
		 for(int i=0;i<n;i++)temp[i]=sc.nextInt();
		 int res[]=findWarmerTemp(temp);
		 for(int i=0;i<res.length;i++){
		 	 System.out.println(res[i]);
		 }
	}
}
