//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
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
            int m=Integer.MAX_VALUE;
            if(s.charAt(i)==s.charAt(j))
            m=Math.min(m,rec(i+1,j-1,s,dp));
            m=Math.min(m,1+rec(i+1,j,s,dp));
            m=Math.min(m,1+rec(i,j-1,s,dp));
            dp[i][j]=m;
            return dp[i][j];
        }
    }
    static int countMin(String str)
    {
        // code here
        int n=str.length();
        int dp[][]=new int[n+1][n+1];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return rec(0,str.length()-1,str,dp);
    }
}