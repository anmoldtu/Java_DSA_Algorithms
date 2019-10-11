import java.util.*;
 import java.util.Scanner;
 
 public class MaxAreaHistogram{
	 public static int maxRectArea(int[] ht) {
	        //write your code here
	        
	        int nser[] = new int[ht.length];
	        int nsel[] = new int[ht.length];
	        Stack<ArrayList<Integer>> stack = new Stack<>();
	        ArrayList<Integer> t2 = new ArrayList<Integer>();
	        t2.add(ht[ht.length-1]);
	        t2.add(ht.length-1);
	        nser[ht.length - 1] = -1;
	        stack.push(t2);
	        for(int i = ht.length - 2;i>=0;--i)
	        {
	            while(!stack.empty() && stack.peek().get(0) > ht[i])
	            {
	                stack.pop();
	            }
	            if(stack.empty())
	            {
	                nser[i] = -1;
	            }
	            else
	            {
	                nser[i] = stack.peek().get(1);
	            }
	            ArrayList<Integer> temp = new ArrayList<Integer>();
	            temp.add(ht[i]);
	            temp.add(i);
	            stack.push(temp);
	        }
	        while(!stack.empty())
	        {
	            stack.pop();
	        }
	        ArrayList<Integer> t3 = new ArrayList<>();
	        t3.add(ht[0]);
	        t3.add(0);
	        stack.push(t3);
	        nsel[0] = -1;
	        stack.push(t3);
	        for(int i = 1;i<ht.length; ++i)
	        {
	            while(!stack.empty() && stack.peek().get(0) > ht[i])
	            {
	                stack.pop();
	            }
	            if(stack.empty())
	            {
	                nsel[i] = -1;
	            }
	            else
	            {
	                nsel[i] = stack.peek().get(1);
	            }
	            ArrayList<Integer> temp = new ArrayList<Integer>();
	            temp.add(ht[i]);
	            temp.add(i);
	            stack.push(temp);
	        }
	        int max = -1;
	        for(int i = 0;i<ht.length;++i)
	        {
	            System.out.print(nsel[i] + " ");
	        }
	        System.out.println();
	        for(int i = 0;i<ht.length;++i)
	        {
	            System.out.print(nser[i] + " ");
	        }
	        for(int i = 0;i<ht.length;++i)
	        {
	            int temp = ht[i]*(nser[i]-nsel[i]-1);
	            if(temp>max)
	            {
	                max = temp;
	            }
	        }
	        return max;
	        
	 	 }
	 
	 
	 	 public static void main(String[] args) {
	 	 	 Scanner scn = new Scanner(System.in);
	 	 	 
	 	 	 int h=scn.nextInt();
	 	 	 int height[]=new int[h];
	 	 	 for(int i=0;i<h;i++){
	 	 	 	 height[i]=scn.nextInt();
	 	 	 }
	 	 	 System.out.println(maxRectArea(height));
	 	 }
 }