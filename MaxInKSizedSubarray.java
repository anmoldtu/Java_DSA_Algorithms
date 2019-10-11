import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 public class MaxInKSizedSubarray {
     
     public static void printMax(int[] arr,int k){
 	 // Write your code here
 	    Stack<Integer> s = new Stack<>();
 	    int nge[] = new int[arr.length];
 	    for(int i = arr.length-1;i>=0;--i)
 	    {
 	        while(!s.empty() && arr[s.peek()] <= arr[i])
 	        {
 	            s.pop();
 	        }
 	        if(s.empty())
 	        {
 	            nge[i] = -1;
 	        }
 	        else
 	        {
 	            nge[i] = s.peek();
 	        }
 	        s.push(i);
 	    }
 	    int i =0,j = 0;
 	    while(i <= arr.length-k)
 	    {
 	        if(i > j)
 	        {
 	            j++;
 	        }
 	        while(j<arr.length)
 	        {
 	            if(nge[j] != -1 && nge[j] < i+k)
 	            {
 	                j = nge[j];
 	            }
 	            else
 	            {
 	                break;
 	            }
 	        }
 	        System.out.print(arr[j] + " ");
 	        i++;
 	    }
 	    
 	 }
 
	 public static void main (String[] args) 
	  {
	 	  Scanner sc = new Scanner(System.in);
	       int n =sc.nextInt();
	         int k=sc.nextInt();
	         
	         int []arr=new int[n];
	         for(int i=0;i<n;i++){
	             arr[i]=sc.nextInt();
	     
	     printMax(arr,k);
	  }
 }
 }