//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int rec(int n,int dp[])
    {
        if(n==1 || n==0)
        return n;
        if(dp[n]!=-1)
        return dp[n];
        else
        {
            int a=((rec(n-1,dp)+rec(n-2,dp))%1000000007);
            dp[n]=a;
            return a;
        }
    }
    static int nthFibonacci(int n){
        // code here
        int dp[]=new int[n+1];
        for(int i=0;i<n+1;i++)
        dp[i]=-1;
        dp[0]=0;
        dp[1]=1;
        return rec(n,dp);
    }
}