import java.io.*;
import java.util.*;

public class SpecialRotten {

    
    static class Helper {
        int i;
        int j;
        double time;
        char ch;
        int fr;

        Helper(int r, int c, double t) {
            this.i = r;
            this.j = c;
            this.time = t;
            this.ch = '1';
            this.fr = 0;
        }
    }
    
    public static double allRotten(int mat[][],ArrayList<Helper> specRotten, ArrayList<Helper> rotten) {

        Queue<Helper> que = new LinkedList<>();
        for (int i = 0; i < specRotten.size(); ++i) {
            Helper hp = specRotten.get(i);
            hp.ch = '3';
            que.add(hp);
            hp.fr = 1;
            mat[specRotten.get(i).i][specRotten.get(i).j] = 1;
        }
        for (int i = 0; i < rotten.size(); ++i) {
            Helper hp = rotten.get(i);
            hp.ch = '2';
            que.add(hp);
            hp.fr = 1;
            mat[rotten.get(i).i][rotten.get(i).j] = 1;
        }
        
        double tim = 0;
        while (que.size() > 0) {
            Helper rem = que.poll();
            if((mat[rem.i][rem.j] == 2 || mat[rem.i][rem.j] == 3) && rem.fr == 0)
            {
                continue;
            }
            
            if(rem.ch == '2')
            {
                mat[rem.i][rem.j] = 2;
                rem.fr = 0;
            }
            else
            {
                mat[rem.i][rem.j] = 3;
                rem.fr = 0;
            }
            tim = rem.time;
            System.out.println(rem.i + " " + rem.j + " " + rem.time);
            if(mat[rem.i][rem.j] == 3)
            {
                if (rem.i + 1 < mat.length && mat[rem.i + 1][rem.j] != 0 && mat[rem.i + 1][rem.j] != 2 && mat[rem.i + 1][rem.j] != 3) {
                    Helper tmp = new Helper(rem.i + 1, rem.j, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.i - 1 >= 0 && mat[rem.i - 1][rem.j] != 0 && mat[rem.i - 1][rem.j] != 2 && mat[rem.i - 1][rem.j] != 3) {
                    Helper tmp = new Helper(rem.i - 1, rem.j, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.j + 1 < mat[0].length && mat[rem.i][rem.j + 1] != 0 && mat[rem.i][rem.j + 1] != 2 && mat[rem.i][rem.j+1] != 3) {
                    Helper tmp = new Helper(rem.i, rem.j + 1, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.j - 1 >= 0 && mat[rem.i][rem.j - 1] != 0 && mat[rem.i][rem.j - 1] != 2 && mat[rem.i][rem.j-1] != 3) {
                    Helper tmp = new Helper(rem.i, rem.j - 1, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.i + 2 < mat.length && mat[rem.i + 2][rem.j] != 0 && mat[rem.i + 2][rem.j] != 2 && mat[rem.i + 2][rem.j] != 3) {
                    Helper tmp = new Helper(rem.i + 2, rem.j, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.i - 2 >= 0 && mat[rem.i - 2][rem.j] != 0 && mat[rem.i - 2][rem.j] != 2 && mat[rem.i - 2][rem.j] != 3) {
                    Helper tmp = new Helper(rem.i - 2, rem.j, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.j + 2 < mat[0].length && mat[rem.i][rem.j + 2] != 0 && mat[rem.i][rem.j + 2] != 2 && mat[rem.i][rem.j+2] != 3) {
                    Helper tmp = new Helper(rem.i, rem.j + 2, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
                if (rem.j - 2 >= 0 && mat[rem.i][rem.j - 2] != 0 && mat[rem.i][rem.j - 2] != 2 && mat[rem.i][rem.j-2] != 3) {
                    Helper tmp = new Helper(rem.i, rem.j - 2, rem.time + 1);
                    tmp.ch = '3';
                    que.add(tmp);
                }
            }
            else
            {
                if (rem.i + 1 < mat.length && mat[rem.i + 1][rem.j] != 0 && mat[rem.i + 1][rem.j] != 2 && mat[rem.i + 1][rem.j] != 3) {
                    Helper tmp = new Helper(rem.i + 1, rem.j, rem.time + 1);
                    tmp.ch = '2';
                    que.add(tmp);
                }
                if (rem.i - 1 >= 0 && mat[rem.i - 1][rem.j] != 0 && mat[rem.i - 1][rem.j] != 2 && mat[rem.i - 1][rem.j] != 3) {
                    Helper tmp = new Helper(rem.i - 1, rem.j, rem.time + 1);
                    tmp.ch = '2';
                    que.add(tmp);
                }
                if (rem.j + 1 < mat[0].length && mat[rem.i][rem.j + 1] != 0 && mat[rem.i][rem.j + 1] != 2 && mat[rem.i][rem.j+1] != 3) {
                    Helper tmp = new Helper(rem.i, rem.j + 1, rem.time + 1);
                    tmp.ch = '2';
                    que.add(tmp);
                }
                if (rem.j - 1 >= 0 && mat[rem.i][rem.j - 1] != 0 && mat[rem.i][rem.j - 1] != 2 && mat[rem.i][rem.j-1] != 3) {
                    Helper tmp = new Helper(rem.i, rem.j - 1, rem.time + 1);
                    tmp.ch = '2';
                    que.add(tmp);
                }
            }
        }
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    return -1;
                }
            }
        }
        System.out.println(tim);
        return tim;
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        ArrayList<Helper> rotten = new ArrayList<>();
        ArrayList<Helper> specRotten = new ArrayList<>();
        int arr[][] = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                arr[i][j] = s.nextInt();
                if (arr[i][j] == 2) {
                    Helper tmp = new Helper(i, j, 0);
                    rotten.add(tmp);
                }
                if (arr[i][j] == 3) {
                    Helper tmp = new Helper(i, j, 0);
                    specRotten.add(tmp);
                }
            }
        }
        double save = allRotten(arr,specRotten,rotten);
        if(save%1 == 0)
        {
            System.out.println((long)save);
        }
        else
        {
            System.out.println((long)save+1);
        }
        
    }
}