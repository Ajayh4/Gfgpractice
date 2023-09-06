//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int e=0;
        for(ArrayList<Integer> a: adj)
        e+=a.size();
        if(e<(V-1))
        return -1;
        for(int i=0;i<V;i++)
        {
            int cnt=0;
            int v[]=new int[V];
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            v[i]=1;
            while(!q.isEmpty())
            {
                int t=q.poll();
                cnt+=1;
                for(int j: adj.get(t))
                {
                    if(v[j]==0)
                    {
                        v[j]=1;
                        q.add(j);
                    }
                }
            }
            if(cnt==V)
            return i;
        }
        return -1;
    }
}