import java.util.*;

public class removeToMakeSmallest {

	public static String smallestNum(int k,String str)
	{
		Stack<Integer> sta = new Stack<>();
		for(int i = 0;i<str.length();++i)
		{
			if(sta.empty() || k==0)
			{
				sta.push((int)(str.charAt(i) -48));
			}
			else
			{
				
				while(!sta.empty() && sta.peek() > (int)(str.charAt(i) -48) && k>0)
				{
					sta.pop();
					k--;
				}
				sta.push((int)(str.charAt(i) -48));
			}
		}
		while(!sta.empty() && k>0)
		{
			sta.pop();
			k--;
		}
		String ans = "";
		while(!sta.empty())
		{
			char c = (char)(sta.pop()+48);
			ans = c + ans;
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		String str = s.next();
		System.out.println(smallestNum(k,str));
	}

}
