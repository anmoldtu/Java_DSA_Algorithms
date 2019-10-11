import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class ConnectingTheRopes {
 	 public static long minCostRopes(long[] arr) {
 	 // Write your code here
 	 
 		 if(arr.length == 1)
 		 {
 			 return arr[0];
 		 }
 	    PriorityQueue<Long> pQueue = new PriorityQueue<Long>(new Comparator<Long>(){
 	      @Override
 	      public int compare(Long o1,Long o2)
 	      {
 	          return o1.compareTo(o2);
 	      }
 	    }); 
 	    for(int i = 0;i<arr.length;++i)
 	    {
 	    	pQueue.add(arr[i]);
 	    }
 	    long sum = 0;
 	    while(pQueue.size() != 1)
 	    {
 	    		long a1 = pQueue.poll();
 	    		long a2 = pQueue.poll();
 	    		sum = sum + a1 + a2;
 	    		pQueue.add(a1+a2);
 	    }
 	    return sum;
 	 }
 
 

 	 // Dont make changes here
 	 public static void main(String[] args) {
 	 	 Scanner scn = new Scanner(System.in);
 	 	 	 int n = scn.nextInt();
 	 	 	 long arr[] = new long[n];
 	 	 	 for (int i = 0; i < n; i++) 
 	 	 	 	 arr[i] = scn.nextLong();
 	 	 	 System.out.println(minCostRopes(arr));
 	 	 
 	 }
 }