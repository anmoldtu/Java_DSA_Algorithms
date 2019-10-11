import java.util.*;
public class killingProcesses {

	public static ArrayList<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // Write your code here
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0;i<ppid.size();++i)
		{
			if(!map.containsKey(ppid.get(i)))
			{
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(pid.get(i));
				map.put(ppid.get(i), tmp);
			}
			else
			{
				ArrayList<Integer> tmp = map.get(ppid.get(i));
				tmp.add(pid.get(i));
				map.put(ppid.get(i), tmp);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(kill);
		ArrayList<Integer> ans = new ArrayList<>();
		while(q.size() > 0)
		{
			int ele = q.poll();
			ArrayList<Integer> x = map.get(ele);
			ans.add(ele);
			q.addAll(x);
		}
		return ans;
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> pid = new ArrayList<>(n);
        List<Integer> ppid = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            pid.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            ppid.add(sc.nextInt());
        }
	 ArrayList<Integer> res=killProcess(pid, ppid, k);
	 Collections.sort(res);
        System.out.println(res);
    }

}
