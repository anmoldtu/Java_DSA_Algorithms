import java.util.*;

public class rottenTomatoes {

	static class Helper {
		int i;
		int j;
		int time;

		Helper(int r, int c, int t) {
			this.i = r;
			this.j = c;
			this.time = t;
		}
	}

	public static int allRotten(int mat[][], ArrayList<Helper> rotten) {

		Queue<Helper> que = new LinkedList<>();
		for (int i = 0; i < rotten.size(); ++i) {
			que.add(rotten.get(i));
			mat[rotten.get(i).i][rotten.get(i).j] = 1;
		}
		int tim = 0;
		while (que.size() > 0) {
			Helper rem = que.poll();
			tim = rem.time;
			if(mat[rem.i][rem.j] == 2)
			{
				continue;
			}
			mat[rem.j][rem.j] = 2;
			if (rem.i + 1 < mat.length && mat[rem.i + 1][rem.j] != 0 && mat[rem.i + 1][rem.j] != 2) {
				Helper tmp = new Helper(rem.i + 1, rem.j, rem.time + 1);
				que.add(tmp);
			}
			if (rem.i - 1 >= 0 && mat[rem.i - 1][rem.j] != 0 && mat[rem.i - 1][rem.j] != 2) {
				Helper tmp = new Helper(rem.i - 1, rem.j, rem.time + 1);
				que.add(tmp);
			}
			if (rem.j + 1 < mat[0].length && mat[rem.i][rem.j + 1] != 0 && mat[rem.i][rem.j + 1] != 2) {
				Helper tmp = new Helper(rem.i, rem.j + 1, rem.time + 1);
				que.add(tmp);
			}
			if (rem.j - 1 >= 0 && mat[rem.i][rem.j - 1] != 0 && mat[rem.i][rem.j - 1] != 2) {
				Helper tmp = new Helper(rem.i, rem.j - 1, rem.time + 1);
				que.add(tmp);
			}
		}
		for (int i = 0; i < mat.length; ++i) {
			for (int j = 0; j < mat[0].length; ++j) {
				if (mat[i][j] == 1) {
					return -1;
				}
			}
		}
		return tim;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		ArrayList<Helper> rotten = new ArrayList<>();
		int arr[][] = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int i = 0; i < M; ++i) {
				arr[i][j] = s.nextInt();
				if (arr[i][j] == 2) {
					Helper tmp = new Helper(i, j, 0);
					rotten.add(tmp);
				}
			}
		}
		System.out.println(allRotten(arr, rotten));
	}

}
