//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void dfs(int n,int v[],int c[],List<List<Integer>> adj,ArrayList<Integer> t)
    {
        v[n]=1;
        t.add(n);
        for(int i: adj.get(n))
        {
            if(v[i]==0)
            {
                dfs(i,v,c,adj,t);
            }
            else
            {
                for(int j: t)
                c[j]=1;
            }
        }
        v[n]=0;
        t.remove(t.size()-1);
    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int v[]=new int[V];
        int c[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(v[i]==0 && c[i]==0)
            {
                dfs(i,v,c,adj,new ArrayList<Integer>());
            }
        }
        List<Integer> r=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(c[i]==0)
            r.add(i);
        }
        return r;
    }
}
