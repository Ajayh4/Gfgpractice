//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static int mod=(int)Math.pow(10,9)+7;
    static long rec(int n,long dp[])
    {
        if(n<=0)
        {
            if(n==0)
            return 1;
            return 0;
        }
        if(dp[n]!=-1)return dp[n];
        else{
        long v=(rec(n-1,dp)%mod+rec(n-2,dp)%mod+rec(n-3,dp)%mod)%mod;
        dp[n]=v;
        return v;
        }
    }
    static long countWays(int n)
    {
        // add your code here
        long dp[]=new long[n+1];
        Arrays.fill(dp,-1);
        return rec(n,dp);
    }
}

