//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    static boolean ans;
    static void dfs(int n,int v[],int pv[],ArrayList<ArrayList<Integer>> adj)
    {
        v[n]=1;
        pv[n]=1;
        for(int i: adj.get(n))
        {
            if(v[i]==0)
            dfs(i,v,pv,adj);
            else
            {
                if(pv[i]==1)
                {
                    ans=true;
                    return;
                }
            }
        }
        pv[n]=0;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ans=false;
        int v[]=new int[V];
        int pv[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(v[i]==0)
            {
                dfs(i,v,pv,adj);
            }
        }
        return ans;
    }
}