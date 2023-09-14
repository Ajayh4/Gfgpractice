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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    static int rec(int i,int sum,int n,int arr[],int dp[][])
    {
        if(i>=n || sum<=0)
        {
            if(sum==0)
            return 1;
            return 0;
        }
        if(dp[i][sum]!=-1)
        return dp[i][sum];
        int p=(rec(i+1,sum-arr[i],n,arr,dp)%1000000007+rec(i+1,sum,n,arr,dp)%1000000007)%1000000007;
        dp[i][sum]=p;
        return p;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n+1][sum+1];
	    for(int i[]: dp)
	    Arrays.fill(i,-1);
	    Arrays.sort(arr);
	    return rec(0,sum,n,arr,dp);
	} 
}