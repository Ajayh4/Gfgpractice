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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static boolean happy(int n)
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(true)
        {
            int s=0;
            String d=Integer.toString(n);
            for(int i=0;i<d.length();i++)
            s+=(int)Math.pow(Integer.parseInt(d.charAt(i)+""),2);
            if(s==1)
            return true;
            if(hm.containsKey(s))
            return false;
            else
            hm.put(s,0);
            n=s;
        }
    }
    static int nextHappy(int N){
        int p=N+1;
        while(true)
        {
            if(happy(p))
            return p;
            p+=1;
        }
    }
}