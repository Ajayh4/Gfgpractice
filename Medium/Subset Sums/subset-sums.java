//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    static ArrayList<Integer> res;
    static void rec(int i,int s,ArrayList<Integer> arr, int n)
    {
        if(i>=n)
        {
            res.add(s);
            return;
        }
        rec(i+1,s+arr.get(i),arr,n);
        rec(i+1,s,arr,n);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        res=new ArrayList<>();
        rec(0,0,arr,N);
        return res;
    }
}