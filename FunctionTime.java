import java.util.*;
 
 public class FunctionTime {
 
    static class Helper{
        int id;
        int s;
        int nmt;
        
        public Helper(int id,int s)
        {
            this.id = id;
            this.s = s;
            this.nmt = 0;
        }
    }
 
     public static int[] exclusiveTime(int n, List<String> logs) {
     // Write your code here
        Stack<Helper> sta = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0;i<logs.size();++i)
        {
            String s = "";
            char status = 's';
            for(int j = 0;j<logs.get(i).length();++j)
            {
                if(logs.get(i).charAt(j) == ':')
                {
                    if(s.charAt(0) == 's')
                    {
                        status = 's';
                    }
                    else if(s.charAt(0) == 'e')
                    {
                        status = 'e';
                    }
                    else
                    {
                        id = Integer.parseInt(s);
                    }
                    s = "";
                }
                else
                {
                    s = s + logs.get(i).charAt(j);
                }
            }
            time = Integer.parseInt(s);
            
            if(status == 's')
            {
                Helper h = new Helper(id,time);
                sta.push(h);
            }
            else
            {
                Helper p = sta.pop();
                ans[p.id] = (time - p.s + 1) - p.nmt;
                if(!sta.empty())
                {
                    Helper q = sta.pop();
                    q.nmt += (time - p.s + 1);
                    sta.push(q);
                }
            }
        }
        return ans;
     }
     
     
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int L = sc.nextInt();
         List<String> logs = new ArrayList<>(L);
         for (int i = 0; i < L; i++) {
             logs.add(sc.next());
         }
         int[] res = exclusiveTime(n, logs);
         for (int i = 0; i < res.length; i++) {
             System.out.print(res[i] + " ");
         }
     }
 
 }