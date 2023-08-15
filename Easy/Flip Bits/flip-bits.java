//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int ml=-1,mr=-1,l=-1,r=-1,m=0,c=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==0)
            {
                c+=1;
                if(c==1)
                {
                    l=i;
                    r=i;
                }
                else
                r=i;
                if(c>m)
                {
                    m=c;
                    ml=l;
                    mr=r;
                }
            }
            else
            {
                c-=1;
                if(c<0)
                c=0;
            }
        }
        if(ml!=-1)
        {
            for(int i=ml;i<=mr;i++)
            a[i]=a[i]^1;
        }
        c=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==1)
            c+=1;
        }
        return c;
    }
}
