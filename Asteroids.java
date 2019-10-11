import java.util.*;
 import java.io.*;
 public class Asteroids {
 	  public static int[] asteroidCollision(int[] asteroids) {
 	 // Write your code    
 	    Stack<Integer> s = new Stack<>();
 	    for(int i = 0;i<asteroids.length;++i)
 	    {
 	        if(s.empty())
 	        {
 	            s.push(asteroids[i]);
 	            continue;
 	        }
 	        if(asteroids[i] < 0 && s.peek() > 0)
 	        {
 	            int k = asteroids[i];
 	            while(!s.empty())
 	            {
 	                if(k<0 && s.peek()>0)
 	                {
 	                    int v = s.pop();
 	                    if(v>k)
 	                    {
 	                        k = v;
 	                    }
 	                }
 	                else
 	                {
 	                    break;
 	                }
 	            }
 	            s.push(k);
 	        }
 	        else
 	        {
 	            s.push(asteroids[i]);
 	        }
 	    }
 	    ArrayList<Integer> ans = new ArrayList<>();
 	    while(!s.empty())
 	    {
 	        ans.add(s.pop());
 	    }
 	    
 	    int[] finalAns = new int[ans.size()];
 	    for(int i = 0;i<finalAns.length;++i)
 	    {
 	    		finalAns[i] = ans.get(i);
 	    }
 	    return finalAns;
 	 }
 	  
 
 
 
 
 	 // Dont make changes 
 	 public static void main(String[] args) {
 	     Scanner sc=new Scanner(System.in);
 	     int n=sc.nextInt();
 	     int ast[]=new int[n];
 	     for(int i=0;i<n;i++)ast[i]=sc.nextInt();
 	     int res[]=asteroidCollision(ast);
 	     for(int v:res){
 	     	 System.out.println(v);
 	     }
 	 }
 
 }