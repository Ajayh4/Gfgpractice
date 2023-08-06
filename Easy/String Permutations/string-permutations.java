//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static ArrayList<String> a;
    static void rec(String r,int c,int v[],String s,int n)
    {
        if(c==n)
        {
            a.add(r);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(v[i]==0)
            {
                v[i]=1;
                rec(r+s.charAt(i),c+1,v,s,n);
                v[i]=0;
            }
        }
    }
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        a=new ArrayList<>();
        int n=S.length();
        int v[]=new int[n];
        rec("",0,v,S,n);
        Collections.sort(a);
        return a;
    }
	   
}
