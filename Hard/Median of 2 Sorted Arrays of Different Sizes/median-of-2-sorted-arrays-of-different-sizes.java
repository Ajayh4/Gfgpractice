//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        int l;
        l=(n+m)/2+1;
        int res[]=new int[l];
        int k=0,i=0,j=0;
        while(i<n && j<m && k<l)
        {
            if(a[i]<=b[j])
            res[k++]=a[i++];
            else
            res[k++]=b[j++];
        }
        while(i<n && k<l)
        res[k++]=a[i++];
        while(j<m && k<l)
        res[k++]=b[j++];
        double ans=0;
        if((n+m)%2==1)
        ans=res[l-1];
        else
        ans=(double)(res[l-1]+res[l-2])/2;
        return ans;
    }
}