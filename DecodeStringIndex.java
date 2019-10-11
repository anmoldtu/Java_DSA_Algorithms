import java.util.*;
  import java.io.*;
  public class DecodeStringIndex {
  	   public static char decodeIndex(String S, int K) {
  	  // Write your code here only    
  	    int c = 0;
  	    for(int i = 0;i<S.length();++i)
  	    {
  	        
  	        if((int)S.charAt(i) >=48 && (int)S.charAt(i) <=57)
  	        {
  	            
  	            c = c*(int)(S.charAt(i)-48);
  	        }
  	        else
  	        {
  	            c++;
  	        }
  	    }
  	    int i = c;
  	    for(int j = S.length() - 1;j>=0;--j)
  	    {
  	        if((int)S.charAt(j) >=48 && (int)S.charAt(j) <=57)
  	        {
  	            i = i/(int)(S.charAt(j)-48);
  	        }
  	        else if((K+1)%i == 0)
  	        {
  	            return S.charAt(j);
  	        }
  	        else
  	        {
  	            K = K%i;
      	        i--;
  	        }
  	    }
  	    return '#';

  	  }
  
  	  // Dont make changes here
  	  public static void main(String[] args) {
  	  	  Scanner sc=new Scanner(System.in);
  	  	  String s=sc.next();
  	  	  int k=sc.nextInt();
  	  	  System.out.println(decodeIndex(s,k));
  	  }
  
  }