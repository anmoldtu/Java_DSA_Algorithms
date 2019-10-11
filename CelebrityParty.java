import java.util.*;

public class CelebrityParty {

	public static int findceleb(int arr[][])
	{
		Stack<Integer> sta = new Stack<>();
		for(int i = 0;i<arr.length;++i)
		{
			sta.push(i);
		}
		int val = -1;
		int val2 = -1;
		while(!sta.empty())
		{
			val1 = sta.pop();
			if(sta.empty())
			{
				break;
			}
			val2 = sta.pop();
			if(arr[val1][val2] == 1)
			{
				sta.push(val2);
			}
			else
			{
				sta.push(val1);
			}
		}
		for(int i = 0;i<arr.length;++i)
		{
			if(i!=val1)
			{
				if(arr[i][val1] == 0)
				{
					return -1;
				}
			}
		}
		for(int i = 0;i<arr.length;++i)
		{
			if(i!=val1)
			{
				if(arr[val1][i] == 1)
				{
					return -1;
				}
			}
		}
		return val1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[][] = new int[N][N];
		for(int i = 0;i<arr.length;++i)
		{
			for(int j = 0;j<arr.length;++j)
			{
				arr[i][j] = s.nextInt();
			}
		}
		System.out.println(findCeleb(arr));
	}

}
