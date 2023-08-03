//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair
{
    int v,d;
    Pair(int y,int z)
    {
        v=y;
        d=z;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int sp[]=new int[N];
		sp[0]=0;
		for(int i=1;i<N;i++)
		sp[i]=-1;
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++)
		adj.add(new ArrayList<Pair>());
		for(int i[]: edges)
		adj.get(i[0]).add(new Pair(i[1],i[2]));
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(0,0));
		while(!q.isEmpty())
		{
		    Pair t=q.poll();
		    for(Pair i: adj.get(t.v))
		    {
		        if(sp[i.v]==-1)
		        {
		            sp[i.v]=i.d+t.d;
		            q.add(new Pair(i.v,i.d+t.d));
		        }
		        else
		        {
		            if(i.d+t.d<sp[i.v])
		            {
		            sp[i.v]=t.d+i.d;
		            q.add(new Pair(i.v,t.d+i.d));
		            }
		        }
		    }
		}
		return sp;
	}
}