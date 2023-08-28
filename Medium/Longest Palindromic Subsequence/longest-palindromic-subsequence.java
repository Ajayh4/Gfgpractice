//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int rec(int i,int j,String s,int dp[][])
    {
        if(i>j)
        return 0;
        else
        {
            if(dp[i][j]!=-1)
            return dp[i][j];
            int ans=0;
            if(s.charAt(i)==s.charAt(j))
            {
                if(i==j)
                ans=1+rec(i+1,j-1,s,dp);
                else
                ans=2+rec(i+1,j-1,s,dp);
            }
            ans=Math.max(ans,Math.max(rec(i+1,j,s,dp),rec(i,j-1,s,dp)));
            dp[i][j]=ans;
            return dp[i][j];
        }
    }
    public int longestPalinSubseq(String S)
    {
        //code here
        int s=S.length();
        int dp[][]=new int[s+1][s+1];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return rec(0,s-1,S,dp);
    }
}