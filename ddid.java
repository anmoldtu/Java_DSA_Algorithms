import java.util.*;
public class ddid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String str = s.next();
		Stack<Integer> sta = new Stack<>();
		int c = 1;
		for(int i = 0;i<str.length();++i)
		{
			if(str.charAt(i) == 'd')
			{
				sta.push(c);
				c++;
			}
			else
			{
				sta.push(c);
				c++;
				
				while(!sta.empty())
				{
					System.out.print(sta.pop() + " ");
				}
			}
		}
		if(sta.empty())
		{
			System.out.print(c + " ");
		}
		else
		{
			sta.push(c);
		}
		while(!sta.empty())
		{
			System.out.print(sta.pop() + " ");
		}
	}

}
