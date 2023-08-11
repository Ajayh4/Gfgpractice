//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    static int ans;
    static long rec(int i,int s,int coins[],int N,long dp[][])
    {
        if(i>=N || s<0)
        return 0;
        if(dp[i][s]!=-1)
        return dp[i][s];
        else
        {
            if(s==0)
            return 1;
            long a=0,b=0;
            if(s-coins[i]>=0)
            {
            a=rec(i,s-coins[i],coins,N,dp);
            dp[i][s-coins[i]]=a;
            }
            b=rec(i+1,s,coins,N,dp);
            dp[i+1][s]=b;
            return a+b;
        }
    }
    public long count(int coins[], int N, int sum) {
        // code here.
        ans=0;
        long dp[][]=new long[N+1][sum+1];
        for(int i=0;i<N+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        return rec(0,sum,coins,N,dp);
    }
}