import java.util.Scanner;

public class largestNumPair {

	public static int maxNumPair(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length-1;++i)
		{
			int tmp = arr[i] + arr[i+1];
			if(tmp > max)
			{
				max = tmp;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[] = new int[N];
		for(int i = 0;i<N;++i)
		{
			arr[i] = s.nextInt();
		}
		System.out.println(maxNumPair(arr));
	}

}
