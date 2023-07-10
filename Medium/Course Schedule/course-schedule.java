//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static Stack<Integer> st;
    static boolean flag;
    static void dfs(int n,ArrayList<ArrayList<Integer>> adj,int v[],int c[])
    {
        v[n]=1;
        c[n]=1;
        for(int i: adj.get(n))
        {
            if(c[i]==1)
            {
                flag=true;
                return;
            }
            if(v[i]==0)
            dfs(i,adj,v,c);
        }
        c[n]=0;
        st.push(n);
    }
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        flag=false;
        st=new Stack<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(ArrayList<Integer> i: prerequisites)
        adj.get(i.get(1)).add(i.get(0));
        int v[]=new int[n];
        int c[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(v[i]==0)
            dfs(i,adj,v,c);
            if(flag==true)
            return new int[0];
        }
        int i=0;
        int r[]=new int[n];
        while(!st.isEmpty())
        r[i++]=st.pop();
        return r;
    }
}