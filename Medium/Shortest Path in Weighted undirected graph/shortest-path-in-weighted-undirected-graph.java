//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair
{
    int x,y;
    Pair(int a,int b)
    {
        x=a;
        y=b;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
        adj.add(new ArrayList<>());
        for(int i[]: edges){
        adj.get(i[0]).add(new Pair(i[1],i[2]));
        adj.get(i[1]).add(new Pair(i[0],i[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.x-b.x);
        pq.add(new Pair(0,1));
        List<Integer> path=new ArrayList<>();
        int sp[]=new int[n+1];
        int parent[]=new int[n+1];
        for(int i=0;i<n;i++)
        parent[i]=i;
        Arrays.fill(sp,-1);
        sp[1]=0;
        int f=1;
        while(!pq.isEmpty())
        {
            Pair t=pq.poll();
            int dist=t.x;
            int node=t.y;
            for(Pair i: adj.get(node))
            {
                if(sp[i.x]==-1)
                {
                    pq.add(new Pair(dist+i.y,i.x));
                    sp[i.x]=dist+i.y;
                    parent[i.x]=node;
                }
                else if(sp[i.x]>dist+i.y)
                {
                    pq.add(new Pair(dist+i.y,i.x));
                    sp[i.x]=dist+i.y;
                    parent[i.x]=node;
                }
            }
        }
        if(sp[n]==-1)
        path.add(-1);
        else
        {
            path.add(n);
            while(parent[n]!=n)
            {
                path.add(0,parent[n]);
                n=parent[n];
            }
        }
        return path;
    }
}