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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair
{
    int n,d;
    Pair(int x,int y)
    {
        n=x;
        d=y;
    }
}
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,0));
        int sp[]=new int[n];
        Arrays.fill(sp,-1);
        sp[src]=0;
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            for(int i: adj.get(t.n))
            {
                if(sp[i]==-1)
                {
                    sp[i]=t.d+1;
                    q.add(new Pair(i,t.d+1));
                }
                else
                {
                    if(sp[i]>t.d+1)
                    {
                        sp[i]=t.d+1;
                        q.add(new Pair(i,t.d+1));
                    }
                }
            }
        }
        return sp;
    }
}