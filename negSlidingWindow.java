import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class negSlidingWindow {
 	 
 	 public  static void window(int[] arr, int k){
 	 // Write your code here
 	    int i = 0,j = 0;
 	    while(i<arr.length-k+1)
 	    {
 	        while(arr[j] > 0 && j < i+k)
 	        {
 	            j++;
 	        }
 	        if(j == i+k)
 	        {
 	            System.out.print(0 + " ");
 	            i++;
 	        }
 	        else
 	        {
 	            while(i <= j)
 	            {
 	                System.out.print(arr[j] + " ");
 	                i++;
 	            }
 	            j++;
 	        }
 	    }
 	 }
 
 
 
 
 
 
 
 	 // Dont make changes here
 	 public static void main (String[] args) {
 	      Scanner s=new Scanner(System.in);
 	 	      int size=s.nextInt();
 	 	      int[]arr=new int[size];
 	 	      for(int i=0;i<size;i++){
 	 	          arr[i]=s.nextInt();
 	 	      }
 	 	      int k=s.nextInt();
 	 	      
 	 	      
 	 	     window(arr, k);
 	 	  
 	 }
 }