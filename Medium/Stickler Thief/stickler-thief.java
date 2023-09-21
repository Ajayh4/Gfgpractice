//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    static int rec(int i,int arr[],int s,int dp[])
    {
        if(i<0)
        return 0;
        else
        {
            if(dp[i]!=-1)
            return dp[i];
            int pm=arr[i]+rec(i-2,arr,s+arr[i],dp);
            int npm=rec(i-1,arr,s,dp);
            dp[i]=Math.max(pm,npm);
            return dp[i];
        }
    }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n-1,arr,0,dp);
    }
}