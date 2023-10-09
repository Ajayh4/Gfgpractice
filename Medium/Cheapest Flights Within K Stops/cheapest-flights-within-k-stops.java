//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    class Pair
    {
        int x,y,h;
        Pair(int a,int b)
        {
            x=a;
            y=b;
        }
        Pair(int a,int b,int h)
        {
            x=a;
            y=b;
            this.h=h;
        }
    }
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
        adj.add(new ArrayList<>());
        for(int i[]: flights)
        adj.get(i[0]).add(new Pair(i[1],i[2]));
        int cost=-1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0,0));
        int sp[]=new int[n+1];
        sp[src]=0;
        Arrays.fill(sp,-1);
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            if(t.x==dst && t.h-1<=k)
            {
                if(cost==-1)
                cost=t.y;
                else
                cost=Math.min(cost,t.y);
            }
            int node=t.x;
            int w=t.y;
            for(Pair i: adj.get(node))
            {
                if(sp[i.x]==-1 || w+i.y<sp[i.x])
                {
                    sp[i.x]=w+i.y;
                    q.add(new Pair(i.x,w+i.y,t.h+1));
                }
            }
        }
        return cost;
    }
}