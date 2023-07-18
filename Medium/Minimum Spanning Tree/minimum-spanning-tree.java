//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class DisjointSet
{
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> rank=new ArrayList<>();
    DisjointSet(int n)
    {
        for(int i=0;i<=n;i++)
        {
            parent.add(i);
            rank.add(0);
        }
    }
    int findparent(int n)
    {
        if(n==parent.get(n))
        return n;
        else
        {
            int t=findparent(parent.get(n));
            parent.set(n,t);
            return parent.get(n);
        }
    }
    void unionbyrank(int u,int v)
    {
        int ulp_u=findparent(u);
        int ulp_v=findparent(v);
        if(ulp_u==ulp_v)
        return;
        if(rank.get(ulp_u)<rank.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u)>rank.get(ulp_v))
        {
            parent.set(ulp_v,ulp_u);
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
}
class Pair
{
    int u,v,w;
    Pair(int x,int y,int z)
    {
        u=x;
        v=y;
        w=z;
    }
}
class paircomp implements Comparator<Pair>
{
    public int compare(Pair i,Pair j)
    {
        if(i.w<j.w)
        return -1;
        else
        return 1;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    PriorityQueue<Pair> pq=new PriorityQueue<>(new paircomp());
	    DisjointSet ds=new DisjointSet(V);
	    for(int i=0;i<edges.length;i++)
	    {
	    pq.add(new Pair(edges[i][0],edges[i][1],edges[i][2]));
	    }
	    int sum=0;
	    while(!pq.isEmpty())
	    {
	        Pair t=pq.poll();
	        if(ds.findparent(t.u)!=ds.findparent(t.v))
	        {
	            sum+=t.w;
	            ds.unionbyrank(t.u,t.v);
	        }
	    }
	    return sum;
	}
}