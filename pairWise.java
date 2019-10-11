import java.util.Scanner;
 import java.util.*;
 //User function Template for Java
 // your task is to complete the function
 // function should return true/false or 1/0
 class pairWise {
 	 public static boolean pairWiseConsecutive(Stack<Integer> st) {
 	 // Write your code here
 	 
 	    Stack<Integer> s2 = new Stack<Integer>();
 	    
 	    while(!st.empty())
 	    {
 	        s2.push(st.pop());
 	    }
 	    while(!s2.empty())
 	    {
 	        int i1 = s2.pop();
 	        st.push(i1);
 	        if(s2.empty())
 	        {
 	            return false;
 	        }
 	        int i2 = s2.pop();
 	        st.push(i2);
 	        int dif = i1 - i2;
 	        if(dif == 1 || dif == -1)
 	        {
 	            return true;
 	        }
 	    }
 	    return false;
 	    
 	 }
 	 
 
 
 	 // Dont make changes here
 	 public static void main(String[] args){
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 Stack<Integer>st=new Stack<>();
 	 	 for(int i=0;i<n;i++){
 	 	 	 st.push(sc.nextInt());
 	 	 }
 	 	 System.out.println(pairWiseConsecutive(st));
 	 	 	 
 	 }
 }