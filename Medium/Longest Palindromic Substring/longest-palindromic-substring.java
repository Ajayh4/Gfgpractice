//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
        // code here
        int le=s.length();
        int lft=0,rht=0,m=0;
        for(int i=0;i<le;i++)
        {
            int l=i,r=i;
            while(l>=0 && r<le && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>m)
                {
                    m=r-l+1;
                    lft=l;
                    rht=r;
                }
                l-=1;
                r+=1;
            }
        }
        for(int i=0;i<le;i++)
        {
            int l=i,r=i+1;
            while(l>=0 && r<le && s.charAt(l)==s.charAt(r))
            {
                if(r-l+1>m)
                {
                    m=r-l+1;
                    lft=l;
                    rht=r;
                }
                l-=1;
                r+=1;
            }
        }
        return s.substring(lft,rht+1);
    }
}