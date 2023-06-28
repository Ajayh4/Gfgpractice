//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static ArrayList<String> res;
    static void rec(int x,int y,int n,int v[][],String r,int m[][])
    {
        v[x][y]=1;
        if(x==(n-1) && y==(n-1))
        {
            res.add(r);
            return;
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int p=x+dx[i];
            int q=y+dy[i];
            if(p>=0 && p<n && q>=0 && q<n && v[p][q]==0 && m[p][q]==1)
            {
                if(i==0)
                rec(p,q,n,v,r+"U",m);
                else if(i==1)
                rec(p,q,n,v,r+"R",m);
                else if(i==2)
                rec(p,q,n,v,r+"D",m);
                else
                rec(p,q,n,v,r+"L",m);
                v[p][q]=0;
            }
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        res=new ArrayList<>();
        if(m[0][0]==0 || m[n-1][n-1]==0)
        {
            res.add("-1");
            return res;
        }
        int v[][]=new int[n][n];
        rec(0,0,n,v,"",m);
        return res;
    }
}