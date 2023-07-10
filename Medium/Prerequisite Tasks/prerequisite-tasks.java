//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean f;
    static void dfs(int n,ArrayList<ArrayList<Integer>> adj,int v[],int c[])
    {
        v[n]=1;
        c[n]=1;
        for(int i: adj.get(n))
        {
            if(c[i]==1)
            {
                f=true;
                return;
            }
            if(v[i]==0)
            dfs(i,adj,v,c);
        }
        c[n]=0;
    }
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        f=false;
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<N;i++)
        a.add(new ArrayList<Integer>());
        for(int[] i: prerequisites)
        a.get(i[0]).add(i[1]);
        int v[]=new int[N];
        int c[]=new int[N];
        for(int i=0;i<N;i++)
        {
            if(v[i]==0)
            dfs(i,a,v,c);
            if(f==true)
            return false;
        }
        return true;
    }
    
}