import java.util.*;
 public class ScoreOfString { 
 
    public static int scoreOfParentheses(String s) {
 	 // Write your code here
 	    Stack<String> sta = new Stack<>();
 	    for(int i = 0;i<s.length();++i)
 	    {
 	        if(s.charAt(i) == '(')
 	        {
 	            sta.push("(");
 	        }
 	        else
 	        {
 	            if(sta.peek().equals("("))
 	            {
 	                sta.pop();
 	                sta.push("1");
 	            }
 	            else
 	            {
 	                int sum = 0;
 	                while(!sta.peek().equals("("))
 	                {
 	                    int tmp = Integer.parseInt(sta.pop());
 	                    sum = tmp + sum;
 	                }
 	                sta.pop();
 	                sum = sum*2;
 	                sta.push(String.valueOf(sum));
 	            }
 	        }
 	    }
 	    int sum = 0;
	    while(!sta.empty())
	    {
	        int tmp = Integer.parseInt(sta.pop());
	        sum = tmp + sum;
	    }
	    return sum;
     }
     
     
 
 
 
 
 
 
 
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         String s=sc.next();
         System.out.println(scoreOfParentheses(s));
     }
     
 
 }