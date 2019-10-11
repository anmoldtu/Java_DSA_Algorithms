import java.util.*;
 public class nextGreaterinOther {
	 public static int[] nextGreaterOther(int[] nums1, int[] nums2) {
	 	 // Write your code here	
	     	 Stack<Integer> s = new Stack<>();
	     	 s.push(nums2[nums2.length-1]);
	     	 int nge[] = new int[nums2.length];
	     	 nge[nums2.length-1] = -1;
	     	 HashMap<Integer,Integer> map = new HashMap<>();
	     	 map.put(nums2[nums2.length-1],nums2.length-1);
	         for(int i = nums2.length-2;i>=0;--i)
	         {
	             if(!map.containsKey(nums2[i]))
	             {
	                 map.put(nums2[i],i);
	             }
	             while(!s.empty() && s.peek() <= nums2[i])
	             {
	                 s.pop();
	             }
	             if(s.empty())
	             {
	                 nge[i] = -1;
	             }
	             else
	             {
	                 nge[i] = s.peek();
	             }
	             s.push(nums2[i]);
	         }
	         int[] ans = new int[nums1.length];
	         for(int i = 0;i<nums1.length;++i)
	         {
	             ans[i] = nge[map.get(nums1[i])];
	         }
	         return ans;
	         
	 	 }
	 	 
	 	 // Dont make changes here
	 	 public static void main(String[] args) {
	 	 	 // TODO Auto-generated method stub
	 	 	 Scanner sc=new Scanner(System.in);
	 	 	 int n1=sc.nextInt(), n2=sc.nextInt();
	 	 	 int[] nums1=new int[n1]; int[] nums2=new int[n2];
	 	 	 for(int i=0;i<n1;i++)nums1[i]=sc.nextInt();
	 	 	 for(int i=0;i<n2;i++)nums2[i]=sc.nextInt();
	 	 	 int[] res=nextGreaterOther(nums1, nums2);
	 	 	 for(int i=0;i<n1;i++)System.out.print(res[i] + " ");
	 	 }    
 }