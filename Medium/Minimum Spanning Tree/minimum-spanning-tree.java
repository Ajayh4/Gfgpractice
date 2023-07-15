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
class Pair
{
    int w,n;
    Pair(int a,int b)
    {
        w=a;
        n=b;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.w-y.w);
	    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	    for(int i=0;i<V;i++)
	    adj.add(new ArrayList<Pair>());
	    int v[]=new int[V];
	    for(int i[]:edges)
	    {
	    adj.get(i[0]).add(new Pair(i[2],i[1]));
	    adj.get(i[1]).add(new Pair(i[2],i[0]));
	    }
	    pq.add(new Pair(0,0));
	    int sum=0;
	    while(!pq.isEmpty())
	    {
	        Pair t=pq.poll();
	        int w=t.w;
	        int n=t.n;
	        if(v[n]==1)
	        continue;
	        v[n]=1;
	        sum+=w;
	        for(Pair i: adj.get(n))
	        {
	            if(v[i.n]==0)
	            {
	                pq.add(new Pair(i.w,i.n));
	            }
	        }
	    }
	    return sum;
	}
}