import java.util.*;
public class CompareString {

	public static boolean compareString(String S, String T) {
	 	 //write your code here
	 	 Stack<Character> s1 = new Stack<>();
	 	 Stack<Character> s2 = new Stack<>();
	 	 for(int i = 0;i<S.length();++i)
	 	 {
	 	     if(S.charAt(i)!='#')
	 	     {
	 	         s1.push(S.charAt(i));
	 	     }
	 	     else
	 	     {
	 	         s1.pop();
	 	     }
	 	 }
	 	 for(int i = 0;i<T.length();++i)
	 	 {
	 	     if(T.charAt(i)!='#')
	 	     {
	 	         s2.push(T.charAt(i));
	 	     }
	 	     else
	 	     {
	 	         s2.pop();
	 	     }
	 	 }
	 	 while(!s1.empty() && !s2.empty())
	 	 {
	 	     char c1 = s1.pop();
	 	     char c2 = s2.pop();
	 	     System.out.println(c1 + " " +  c2);
	 	     if(c1!=c2)
	 	     {
	 	         return false;
	 	     }
	 	 }
	 	 if(!s1.empty() || !s2.empty())
	 	 {
	 	     return false;
	 	 }
	 	 return true;
	 }

//Driver program
	 public static void main(String[] args) {
	 	 Scanner scn = new Scanner(System.in);
	 	 String s1 = scn.next();
	 	 String s2 = scn.next();

	 	 System.out.println(compareString(s1, s2));
	 }
}
