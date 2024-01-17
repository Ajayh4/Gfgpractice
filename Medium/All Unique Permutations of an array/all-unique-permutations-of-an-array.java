//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static HashSet<ArrayList<Integer>> res;
    static void rec(int n,ArrayList<Integer> arr,ArrayList<Integer> a,int f[])
    {
        if(a.size()==n)
        {
            res.add(new ArrayList<>(a));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(f[i]==0)
            {
                f[i]=1;
                a.add(arr.get(i));
                rec(n,arr,a,f);
                a.remove(a.size()-1);
                f[i]=0;
            }
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        res=new LinkedHashSet<>();
        int f[]=new int[n];
        Collections.sort(arr);
        rec(n,arr,new ArrayList<>(),f);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(ArrayList<Integer> i: res)
        ans.add(i);
        return ans;
    }
};