import java.util.*; 
public class KnightInChessboard 
 { 
 // Write the code
	
	static class Helper{
		int row;
		int col;
		int level;
		
		public Helper(int row,int col,int level)
		{
			this.row = row;
			this.col = col;
			this.level = level;
		}
	}
	
 static int knightChessboard(int knightPos[], int targetPos[],int N)
  {
	 	int board[][] = new int[N+1][N+1];
	 	Helper src = new Helper(knightPos[0],knightPos[1],0);
		Queue<Helper> q= new LinkedList<>();
		q.add(src);
		int level = 0;
		while(q.size() > 0)
		{
			Helper tmp = q.poll();
			if(tmp.row == targetPos[0] && tmp.col == targetPos[1])
			{
				return tmp.level;
			}
			board[tmp.row][tmp.col] = 1;
			if((tmp.row + 1) <= N && (tmp.col + 2) <= N && board[tmp.row + 1][tmp.col + 2] == 0)
			{
				int r = tmp.row + 1;
				int c = tmp.col + 2;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row - 1) > 0 && (tmp.col + 2) <= N && board[tmp.row - 1][tmp.col + 2] == 0)
			{
				int r = tmp.row - 1;
				int c = tmp.col + 2;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row + 1) <= N && (tmp.col - 2) > 0 && board[tmp.row + 1][tmp.col - 2] == 0)
			{
				
				int r = tmp.row + 1;
				int c = tmp.col - 2;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row - 1) > 0 && (tmp.col - 2) > 0 && board[tmp.row - 1][tmp.col - 2] == 0)
			{
				int r = tmp.row - 1;
				int c = tmp.col - 2;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row + 2) <= N && (tmp.col + 1) <= N && board[tmp.row + 2][tmp.col + 1] == 0)
			{
				
				int r = tmp.row + 2;
				int c = tmp.col + 1;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row - 2) > 0 && (tmp.col + 1) <= N && board[tmp.row - 2][tmp.col + 1] == 0)
			{
				int r = tmp.row - 2;
				int c = tmp.col + 1;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row - 2) > 0 && (tmp.col - 1) > 0 && board[tmp.row - 2][tmp.col - 1] == 0)
			{
				int r = tmp.row - 2;
				int c = tmp.col - 1;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
			if((tmp.row + 2) <= N && (tmp.col - 1) > 0 && board[tmp.row + 2][tmp.col - 1] == 0)
			{
				int r = tmp.row + 2;
				int c = tmp.col - 1;
				Helper t2 = new Helper(r,c,tmp.level + 1);
				q.add(t2);
			}
		}
		return -1;
 } 
 
 
 
 
 
 // Dont change here 
 public static void main(String[] args) 
 {       Scanner sc=new Scanner(System.in);
 	 int N = sc.nextInt(); 
 	 int knightPos[] = new int[2]; 
 	 int targetPos[] = new int[2];
         knightPos[0]=sc.nextInt();knightPos[1]=sc.nextInt();
         targetPos[0]=sc.nextInt();targetPos[1]=sc.nextInt();
 	 	 System.out.println(knightChessboard(knightPos, targetPos, N)); 
 	 } 
 }