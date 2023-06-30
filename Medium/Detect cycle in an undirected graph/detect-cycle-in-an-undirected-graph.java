//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair
{
    int p,n;
    Pair(int x,int y)
    {
        p=x;
        n=y;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int v[]=new int[V];
        for(int j=0;j<V;j++)
        {
            if(v[j]==0)
            {
                Queue<Pair> q=new LinkedList<>();
                q.add(new Pair(-1,j));
                v[j]=1;
                while(!q.isEmpty())
                {
                    Pair t=q.poll();
                    int n=t.n;
                    for(int i: adj.get(n))
                    {
                        if(v[i]==0)
                        {
                            q.add(new Pair(n,i));
                            v[i]=1;
                        }
                        else
                        {
                            if(t.p!=i)
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}