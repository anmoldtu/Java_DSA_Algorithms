import java.util.*;
class decodeStr {
 
 public static String decode(String s) {
 //Write your code here
    Stack<String> stack = new Stack<>();
    for(int i = s.length()-1;i>=0;--i)
    {
        if(s.charAt(i) == ']')
        {
            stack.push("]");
        }
        else if(s.charAt(i) == '[')
        {
            String tmp = "";
            while(!stack.peek().equals("]"))
            {
                tmp = tmp + stack.pop();
            }
            stack.pop();
            stack.push(tmp);
//            System.out.println(stack.peek());
        }
        else if((int)s.charAt(i) >=97 && (int)s.charAt(i) <= 122) 
        {
            String tmp = "";
            tmp = tmp + s.charAt(i);
            stack.push(tmp);
        }
        else
        {
            String tmp = stack.pop();
            String num = "";
            int j;
            for(j = i;j>=0;--j)
            {
                if((int)s.charAt(j) >=48 && (int)s.charAt(j) <= 57)
                {
                    num = s.charAt(j) + num;
                }
                else
                {
                    break;
                }
            }
            i = j+1;
            String str = "";
            for(int k = 1;k<=Integer.parseInt(num);++k)
            {
                str = str + tmp;
            }
            stack.push(str);
//            System.out.println(stack.peek());
        }
    }
    String str = "";
    while(!stack.empty())
    {
    		str = str + stack.pop();
    }
    return str;
 }
 
 
 //Dont make any changes here
 public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
 String s=sc.next();
 System.out.println(decode(s));
 }
 
 }