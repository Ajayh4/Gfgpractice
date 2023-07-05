//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
    static int rec(ArrayList<Integer> a,int i,int k,int n)
    {
        if(a.size()==1)
        return a.get(0);
        else
        {
            i=(i+k-1)%a.size();
            a.remove(i);
            return rec(a,i,k,n);
        }
    }
    public int josephus(int n, int k)
    {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<=n;i++)
        a.add(i);
        return rec(a,0,k,n); 
    }
}

