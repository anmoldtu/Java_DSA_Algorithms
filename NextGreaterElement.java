//Java program to print next 
 import java.util.*;
 import java.io.*;
 
 public class NextGreaterElement 
 { 
 	 static class stack 
 	 { 
 	 	 int top; 
 	 	 int items[] = new int[100]; 
 
 	 	 // Stack functions to be used by printNGE 
 	 	 void push(int x) 
 	 	 { 
 	 	 	 if (top == 99) 
 	 	 	 { 
 	 	 	 	 System.out.println("Stack full"); 
 	 	 	 } 
 	 	 	 else
 	 	 	 { 
 	 	 	 	 items[++top] = x; 
 	 	 	 } 
 	 	 } 
 
 	 	 int pop() 
 	 	 { 
 	 	 	 if (top == -1) 
 	 	 	 { 
 	 	 	 	 System.out.println("Underflow error"); 
 	 	 	 	 return -1; 
 	 	 	 } 
 	 	 	 else
 	 	 	 { 
 	 	 	 	 int element = items[top]; 
 	 	 	 	 top--; 
 	 	 	 	 return element; 
 	 	 	 } 
 	 	 } 
 
 	 	 boolean isEmpty() 
 	 	 { 
 	 	 	 return (top == -1) ? true : false; 
 	 	 } 
 	 } 
 
 	 /* prints element and NGE pair for 
 	 all elements of arr[] of size n */
 	 static void printNGE(int arr[], int n) 
 	 { 
 	 	  Stack<Integer> s = new Stack();
 	 	  s.push(arr[arr.length-1]);
 	 	  int nge[] = new int[arr.length];
 	 	  nge[arr.length-1] = -1;
 	 	  for(int i = arr.length-2;i>=0;--i)
 	 	  {
 	 	      if(!s.empty() && s.peek() < arr[i])
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
 	 	      s.push(arr[i]);
 	 	  }
 	 	  for(int i = 0;i<arr.length;++i)
 	 	  {
 	 	      System.out.println(nge[i]);
 	 	  }
 	 } 
 
 	 public static void main(String[] args) 
 	 { 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 int arr[] = new int[n];
 	 	 for(int i=0;i<n;i++)arr[i]=sc.nextInt(); 
 	 	 printNGE(arr, n); 
 	 } 
 }