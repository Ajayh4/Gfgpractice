//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int rec(int i,int j,int a,int b,String s1,String s2,int dp[][])
    {
        if(i>=a || j>=b)
        return 0;
        else
        {
            if(dp[i][j]!=-1)
            return dp[i][j];
            int ans=0;
            if(s1.charAt(i)==s2.charAt(j))
            ans=1+rec(i+1,j+1,a,b,s1,s2,dp);
            dp[i][j]=Math.max(ans,Math.max(rec(i+1,j,a,b,s1,s2,dp),rec(i,j+1,a,b,s1,s2,dp)));
            return dp[i][j];
        }
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][]=new int[x+1][y+1];
        for(int i=0;i<x+1;i++)
        {
            for(int j=0;j<y+1;j++)
            dp[i][j]=-1;
        }
        return rec(0,0,x,y,s1,s2,dp);
    }
    
}