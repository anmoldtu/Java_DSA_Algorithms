import java.util.*;

public class NumOfRev {

	public static int numRev(String tmp)
	{
		Stack<Character> s = new Stack<>();
		for(int i = 0;i<tmp.length();++i)
		{
			if(tmp.charAt(i) == '{')
			{
				s.push('{');
			}
			else
			{
				if(s.empty())
				{
					s.push('}');
				}
				else
				{
					if(s.peek() == '{')
					{
						s.pop();
					}
					else
					{
						s.push('}');
					}
				}
			}
		}
		int o1=0,o2=0;
		while(!s.empty())
		{
			if(s.peek() =='{')
			{
				o1++;
			}
			else
			{
				o2++;
			}
			s.pop();
		}
		int ans = (o1+1)/2 +(o2+1)/2;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s =new Scanner(System.in);
		System.out.println(numRev(s.next()));
	}

}
