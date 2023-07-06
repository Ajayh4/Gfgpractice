//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    class Pair
    {
        int n,d;
        Pair(int x,int y)
        {
            n=x;
            d=y;
        }
    }
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Pair o=new Pair(0,0);
        Queue<Pair> q=new LinkedList<>();
        q.add(o);
        int v[]=new int[V];
        v[0]=1;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                Pair t=q.poll();
                if(t.n==X)
                return t.d;
                for(int j: adj.get(t.n))
                {
                    if(v[j]==0)
                    {
                        q.add(new Pair(j,t.d+1));
                        v[j]=1;
                    }
                }
            }
        }
        return -1;
    }
}