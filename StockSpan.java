import java.util.*;
 class StockSpan{
 static class StockSpanner {
 // Complete the functions
 
    Stack<Integer> s;
    ArrayList<Integer> check; 
    int c;
     public StockSpanner() {
         s = new Stack<>();
         check = new ArrayList<Integer>();
         for(int i = 0;i<10000;++i)
         {
             check.add(0);
         }
         c = 0;
     }
 
     public int next(int price) {
         if(s.empty())
         {
             check.set(c,price);
             s.push(c);
             c++;
             return 1;
         }
         else
         {
        	 	int k = 0;
             while(!s.empty() && check.get(s.peek()) <= price)
             {
            	 	k++;
                 s.pop();
             }
             if(s.empty())
             {
                 check.set(c,price);
                 s.push(c);
                 c++;
                 return c;
             }
             else
             {
                 check.set(c,price);
                 s.push(c);
                 c++;
                 return c-1 - s.peek();
             }
         }
     }
 }
 
 

 
 //Dont make chamnges here
 	 public static void main(String[] args){
 	 	 StockSpanner ss=new StockSpanner();
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 for(int i=0;i<n;i++){
 	 	 	 System.out.println(ss.next(sc.nextInt()));
 	 	 }
 	 }
 
 
 
 
 }