import java.util.*;
 class CannonicalPath {
     public static String absoluteCanonicalPath(String s) {
 	 // Write your code here
 	    Stack<String> sta= new Stack<>();
 	    for(int i = 0;i<s.length();++i)
 	    {
 	        if(s.charAt(i) == '/')
 	        {
 	            if(sta.empty())
 	            {
 	                sta.push("/");
 	            }
 	            else if(sta.peek().equals("/"))
 	            {
 	                continue;
 	            }
 	            else
 	            {
 	                sta.push("/");
 	            }
 	        }
 	        else if(s.charAt(i) == '.')
 	        {
 	            if(i != s.length()-1 && s.charAt(i+1) =='.')
 	            {
 	                sta.pop();
 	                if(!sta.empty())
 	                {
 	                    sta.pop();
 	                }
 	                
 	                i++;
 	            }
 	        }
 	        else
 	        {
 	            String tmp = "";
 	            while(i != s.length()-1)
 	            {
 	                if(s.charAt(i) == '/')
 	                {
 	                    break;
 	                }
 	                else
 	                {
 	                    tmp = tmp + s.charAt(i);
 	                    i++;
 	                }
 	            }
 	            sta.push(tmp);
 	            i--;
 	        }
 	    }
 	    if(!sta.empty() && sta.peek().equals("/"))
 	    {
 	        sta.pop();
 	    }
 	    if(sta.empty())
 	    {
 	        return "/";
 	    }
 	    String ans = "";
 	    while(!sta.empty())
 	    {
 	        ans = sta.pop() + ans;
 	    }
 	    return ans;
     }
 
 
 
  // Dont make changes here   
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         String path=sc.next();
         System.out.print(absoluteCanonicalPath(path));
     }
 }