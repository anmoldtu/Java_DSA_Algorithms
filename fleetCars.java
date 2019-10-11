import java.util.*;
 class fleetcars {
     
     static class pair{
         int pos;
         int spee;
         public pair(int po,int sp)
         {
             pos = po;
             spee = sp;
         }
     }
     
     
     public static int carFleet(int target, int[] position, int[] speed) {
      // Write your code here   
      
      pair[] obj = new pair[position.length];
      for(int i = 0;i<position.length;++i)
      {
          obj[i] = new pair(position[i],speed[i]);
      }
      Arrays.sort(obj,new Comparator<pair>(){
          @Override
          public int compare(pair o1,pair o2)
          {
        	  	Integer p1 = new Integer(o1.pos);
        	  	Integer p2 = new Integer(o2.pos);
              return p1.compareTo(p2);
          }
          });
      for(int i = 0;i<position.length;++i)
      {
          position[i] = obj[i].pos;
          speed[i] = obj[i].spee;
      }
      float[] time = new float[position.length];
      for(int i = 0;i<position.length;++i)
      {
          time[i] = (float)(target - position[i])/(float)speed[i];
      }
      int count = 0;
      for(int i = time.length-1;i>=0;)
      {
          float val = time[i];
          count++;
          int j = i-1;
          for(;j>=0;--j)
          {
              if(time[j] > val)
              {
                  break;
              }
          }
          i = j;
      }
      return count;
     } 
     
     
     
     // Dont make changes here
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int target=sc.nextInt();
         int n=sc.nextInt();
         int[] pos=new int[n];
         int[] speed=new int[n];
         for(int i=0;i<n;i++)pos[i]=sc.nextInt();
         for(int i=0;i<n;i++)speed[i]=sc.nextInt();
         System.out.println(carFleet(target, pos, speed));
     }
 }