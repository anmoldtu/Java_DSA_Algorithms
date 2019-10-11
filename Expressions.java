import java.util.*;

public class Expressions {
	
	public static int performOp(int a1,int a2,char op)
	{
		if(op == '+')
		{
			return a1+a2;
		}
		else if(op == '-')
		{
			return a1-a2;
		}
		else if(op == '*')
		{
			return a1*a2;
		}
		else if(op == '/')
		{
			return a1/a2;
		}
		else
		{
			return (int)Math.pow(a1, a2);
		}
	}
	
	public static String infixToPostfix(String exp,HashMap<Character,Integer> priority)
	{
		Stack<String> ch = new Stack<>();
		Stack<Character> op = new Stack<>();
		exp = "(" + exp + ")";
		for(int i = 0;i<exp.length();++i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(exp.charAt(i) == '(')
			{
				op.push('(');
			}
			else if(exp.charAt(i) == ')')
			{
				while(op.peek() != '(')
				{
					char operator = op.pop();
					String val1 = ch.pop();
					String val2 = ch.pop();
					String putback = val2 + val1 + operator;
					ch.push(putback);
				}
				op.pop();
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				if(op.empty() || priority.get(op.peek()) < priority.get(exp.charAt(i)))
				{
					op.push(exp.charAt(i));
				}
				else
				{
					while(!op.empty() && (priority.get(op.peek()) >= priority.get(exp.charAt(i))))
					{
						char operator = op.pop();
						String val1 = ch.pop();
						String val2 = ch.pop();
						String putback = val2 + val1 + operator;
						ch.push(putback);
					}
					op.push(exp.charAt(i));
				}
			}
			else
			{
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				ch.push(tmp);
			}	
		}
		return ch.peek();
	}
	
	public static String infixToPrefix(String exp,HashMap<Character,Integer> priority)
	{
		Stack<String> ch = new Stack<>();
		Stack<Character> op = new Stack<>();
		exp = "(" + exp + ")";
		for(int i = 0;i<exp.length();++i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(exp.charAt(i) == '(')
			{
				op.push('(');
			}
			else if(exp.charAt(i) == ')')
			{
				while(op.peek() != '(')
				{
					char operator = op.pop();
					String val1 = ch.pop();
					String val2 = ch.pop();
					String putback = operator + val2 + val1;
					ch.push(putback);
				}
				op.pop();
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				if(op.empty() || priority.get(op.peek()) < priority.get(exp.charAt(i)))
				{
					op.push(exp.charAt(i));
				}
				else
				{
					while(!op.empty() && (priority.get(op.peek()) >= priority.get(exp.charAt(i))))
					{
						char operator = op.pop();
						String val1 = ch.pop();
						String val2 = ch.pop();
						String putback = operator + val2 + val1;
						ch.push(putback);
					}
					op.push(exp.charAt(i));
				}
			}
			else
			{
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				ch.push(tmp);
			}	
		}
		return ch.peek();
	}
	
	public static int infixEvaluation(String exp,HashMap<Character,Integer> priority)
	{
		Stack<Integer> ch = new Stack<>();
		Stack<Character> op = new Stack<>();
		exp = "( " + exp + " )";
		for(int i = 0;i<exp.length();++i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(exp.charAt(i) == '(')
			{
				op.push('(');
			}
			else if(exp.charAt(i) == ')')
			{
				while(op.peek() != '(')
				{
					char operator = op.pop();
					Integer val1 = ch.pop();
					Integer val2 = ch.pop();
					int putback = performOp(val2,val1,operator);
					ch.push(putback);
				}
				op.pop();
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				if(op.empty() || priority.get(op.peek()) < priority.get(exp.charAt(i)))
				{
					op.push(exp.charAt(i));
				}
				else
				{
					while(!op.empty() && (priority.get(op.peek()) >= priority.get(exp.charAt(i))))
					{
						char operator = op.pop();
						Integer val1 = ch.pop();
						Integer val2 = ch.pop();
						int putback = performOp(val2,val1,operator);
						ch.push(putback);
					}
					op.push(exp.charAt(i));
				}
			}
			else
			{
				String tmp = "";
				int j;
				for(j=i;j<exp.length();++j)
				{
					if(exp.charAt(j) == ' ')
					{
						break;
					}
					tmp = tmp + exp.charAt(j);
				}
				int num = Integer.parseInt(tmp);
				i = j-1;
				ch.push(num);
			}	
		}
		return ch.peek();
	}
	
	public static String postfixToInfix(String exp,HashMap<Character,Integer> priority)
	{
		Stack<String> ch = new Stack<>();
		for(int i = 0;i<exp.length();++i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				
				String val1 = ch.pop();
				String val2 = ch.pop();
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				String putback = "(" +  val2 + tmp + val1 + ")";
				ch.push(putback);
			}
			else
			{
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				ch.push(tmp);
			}	
		}
		return ch.peek();
	}

	
	public static String postfixToPrefix(String exp,HashMap<Character,Integer> priority)
	{
		Stack<String> ch = new Stack<>();
		for(int i = 0;i<exp.length();++i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				
				String val1 = ch.pop();
				String val2 = ch.pop();
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				String putback =  tmp + val2 +  val1;
				ch.push(putback);
			}
			else
			{
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				ch.push(tmp);
			}	
		}
		return ch.peek();
	}
	
	public static int postfixEvaluation(String exp,HashMap<Character,Integer> priority)
	{
		Stack<Integer> ch = new Stack<>();
		for(int i = 0;i<exp.length();++i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				
				Integer val1 = ch.pop();
				Integer val2 = ch.pop();
				int putback = performOp(val2,val1,exp.charAt(i));
				ch.push(putback);
			}
			else
			{
				
				String tmp = "";
				int j;
				for(j=i;j<exp.length();++j)
				{
					if(exp.charAt(j) == ' ')
					{
						break;
					}
					tmp = tmp + exp.charAt(j);
				}
				int num = Integer.parseInt(tmp);
				i = j-1;
				ch.push(num);
			}	
		}
		return ch.peek();
	}
	
	public static String prefixToInfix(String exp,HashMap<Character,Integer> priority)
	{
		Stack<String> ch = new Stack<>();
		for(int i = exp.length()-1;i>=0;--i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				
				String val1 = ch.pop();
				String val2 = ch.pop();
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				String putback = "(" +  val1 + tmp + val2 + ")";
				ch.push(putback);
			}
			else
			{
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				ch.push(tmp);
			}	
		}
		return ch.peek();
	}
	
	public static String prefixToPostfix(String exp,HashMap<Character,Integer> priority)
	{
		Stack<String> ch = new Stack<>();
		for(int i = exp.length()-1;i>=0;--i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				
				String val1 = ch.pop();
				String val2 = ch.pop();
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				String putback =  val1 +  val2 + tmp;
				ch.push(putback);
			}
			else
			{
				String tmp = "";
				tmp = tmp + exp.charAt(i);
				ch.push(tmp);
			}	
		}
		return ch.peek();
	}
	
	public static int prefixEvaluation(String exp,HashMap<Character,Integer> priority)
	{
		Stack<Integer> ch = new Stack<>();
		for(int i = exp.length()-1;i>=0;--i)
		{
			if(exp.charAt(i) == ' ')
			{
				continue;
			}
			else if(priority.containsKey(exp.charAt(i)))
			{
				
				Integer val1 = ch.pop();
				Integer val2 = ch.pop();
				int putback = performOp(val1,val2,exp.charAt(i));
				ch.push(putback);
			}
			else
			{
				
				String tmp = "";
				int j;
				for(j=i;j>=0;--j)
				{
					if(exp.charAt(j) == ' ')
					{
						break;
					}
					tmp = exp.charAt(j) + tmp;
				}
				int num = Integer.parseInt(tmp);
				i = j+1;
				ch.push(num);
			}	
		}
		return ch.peek();
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashMap<Character,Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('/', 2);
		priority.put('*', 2);
		priority.put('^', 3);
		priority.put('(', 0);
		Scanner sc = new Scanner(System.in);
//		System.out.println(infixToPostfix(sc.nextLine(),priority));
//		System.out.println(infixToPrefix(sc.nextLine(),priority));
//		System.out.println(postfixToInfix(sc.nextLine(),priority));
//		System.out.println(postfixToPrefix(sc.nextLine(),priority));
//		System.out.println(prefixToInfix(sc.nextLine(),priority));
//		System.out.println(prefixToPostfix(sc.nextLine(),priority));
//		System.out.println(prefixEvaluation(sc.nextLine(),priority));
		System.out.println(infixEvaluation(sc.nextLine(),priority));
	}

}
