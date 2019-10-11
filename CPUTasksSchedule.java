import java.util.*;
 
 public class CPUTasksSchedule {
 
     static class Helper{
         
         char ch;
         int freq;
         
         Helper(char ch,int freq)
         {
        	 	this.ch = ch;
        	 	this.freq = freq;
         }
     }
     public static int minInterval(char[] tasks, int n) {
     // Write your code here
     
     HashMap<Character,Integer> fmap = new HashMap<>();
     int time[] = new int[27];
     for(int i = 0;i<tasks.length;++i)
     {
         if(fmap.containsKey(tasks[i]))
         {
        	 	fmap.put(tasks[i], fmap.get(tasks[i]) + 1);
         }
         else
         {
        	 	fmap.put(tasks[i],1);
         }
     }
     PriorityQueue<Helper> pQueue = new PriorityQueue<Helper>(new Comparator<Helper>(){
	      @Override
	      public int compare(Helper o1,Helper o2)
	      {
	    	  	  Integer v1 = new Integer(o1.freq);
	    	  	  Integer v2 = new Integer(o2.freq);
	          return v2.compareTo(v1);
	      }
	    }); 
     
     for(char i : fmap.keySet())
     {
    	 	Helper h = new Helper(i,fmap.get(i));
    	 	pQueue.add(h);
     }
     while(pQueue.size()!=0)
     {
    	 	
     }
     
     
        
 	    
     }
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int N = sc.nextInt();
         char[] tasks = new char[N];
         for (int i = 0; i < N; i++) {
             tasks[i] = sc.nextLine().charAt(0);
         }
         System.out.println(minInterval(tasks, n));
     }
 
 }