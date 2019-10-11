import java.util.*;
 import java.util.Scanner;
 public class MinStack {
     
	 static int minEle = -1;
     static Stack<Integer> s=new Stack<>();
     
     //Complete the below 3 functions only
     static int getMin()
     {
    	 	return minEle;
         }
     static int pop()
     {
            if(s.empty())
    	 	{
    	 		return -1;
    	 	}
    	 	if(s.peek() <= minEle)
    	 	{
    	 		int val = s.pop();
    	 		minEle = 2*minEle - val;
    	 		if(s.empty())
    	 		{
    	 		    minEle = -1;
    	 		}
    	 		return save;
    	 	}
    	 	else
    	 	{
    	 	    int val =  s.pop();
    	 	    if(s.empty())
    	 		{
    	 		    minEle = -1;
    	 		}
    	 		return val;
    	 	}
     }
     static void push(int x)
     {
    	 	if(s.empty())
    	 	{
    	 		s.push(x);
    	 		minEle = x;
    	 	}
    	 	else if(x < minEle)
    	 	{
    	 		s.push(x + (x - minEle));
    	 	}
    	 	else
    	 	{
    	 		s.push(x);
    	 	}
     }	 

 
 	 // Dont make changes here    
 	 public static void main(String[] args) {
 	 	 // TODO Auto-generated method stub
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 int[] query=new int[n];
 	 	 for(int i=0;i<n;i++){
 	 	 	 query[i]=sc.nextInt();
 	 	 }
 	 	 int i=0;
 	 	 while(i<n){
 	 	 	 if(query[i]==1){
 	 	 	 	 i++;
 	 	 	 	 push(query[i]);
 	 	 	 }
 	 	 	 else if(query[i]==2){
 	 	 	 	 System.out.println(pop());
 	 	 	 }
 	 	 	 else if(query[i]==3){
 	 	 	 	 System.out.println(getMin());
 	 	 	 }
 	 	 	 i++;
 	 	 }
 	 }
 
 }