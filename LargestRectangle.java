import java.util.Scanner;
 import java.util.Stack;
 
 public class LargestRectangle {
  
	 public static void disp(int arr[])
	 {
		 for(int i = 0;i<arr.length;++i)
		 {
			 System.out.print(arr[i] + " ");
		 }
		 System.out.println();
	 }
	 
 public static int maxrect(int arr[][]){
 // Write your code here only
	 int allmax = -1;
	 for(int i = 0;i<arr.length;++i)
	 {
		 if(i!=0)
		 {
			 for(int j = 0;j<arr[i].length;++j)
			 {
				 if(arr[i][j]!=0)
				 {
					 arr[i][j] = arr[i-1][j] + arr[i][j];
				 }
			 }
		 }
		 int nser[] = new int[arr[0].length];
		 int nsel[] = new int[arr[0].length];
		 Stack<Integer> s = new Stack<>();
		 for(int j = 0;j<arr[i].length;++j)
		 {
			 while(!s.empty() && arr[i][j] <= arr[i][s.peek()])
			 {
				 s.pop();
			 }
			 if(s.empty())
			 {
				 nsel[j] = -1;
			 }
			 else
			 {
				 nsel[j] = s.peek();
			 }
			 s.push(j);
		 }
		 while(!s.empty())
		 {
			 s.pop();
		 }
		 for(int j = arr[i].length-1;j>=0;j--)
		 {
			 while(!s.empty() && arr[i][j] <= arr[i][s.peek()])
			 {
				 s.pop();
			 }
			 if(s.empty())
			 {
				 nser[j] = arr[i].length;
			 }
			 else
			 {
				 nser[j] = s.peek();
			 }
			 s.push(j);
		 }
		 int max = -1;
		 for(int j = 0;j<arr[i].length;++j)
		 {
			 int area = (nser[j] - nsel[j]-1)*arr[i][j];
			 if(area > max)
			 {
				 max = area;
			 }
		 }
		 if(max > allmax)
		 {
			 allmax = max;
		 }
	 }
	 return allmax;
 }
 	 //Dont make changes
 	 public static void main(String[] args) {
 	 	 Scanner sc=new Scanner(System.in);	 
 	 	 int row=sc.nextInt();
 	 	 int col=sc.nextInt();
 	 	 int[][] A=new int[row][col];
 	 	 for(int i=0;i<row;i++)
 	 	 	 for(int j=0;j<col;j++)
 	 	 	 	 A[i][j]=sc.nextInt();
           System.out.println( maxrect(A));
     
 	 }
 
 }