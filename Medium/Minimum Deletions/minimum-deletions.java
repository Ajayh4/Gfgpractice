//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int rec(int i,int j,String s,int dp[][])
    {
        if(i>j)
        return 0;
        else
        {
            if(dp[i][j]!=-1)
            return dp[i][j];
            else{
            int ans=Integer.MAX_VALUE;
            if(s.charAt(i)==s.charAt(j))
            ans=Math.min(ans,rec(i+1,j-1,s,dp));
            ans=Math.min(ans,1+rec(i+1,j,s,dp));
            ans=Math.min(ans,1+rec(i,j-1,s,dp));
            return dp[i][j]=ans;
            }
        }
    }
    static int minimumNumberOfDeletions(String s) {
        //your code here
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return  rec(0,s.length()-1,s,dp);
    }
}