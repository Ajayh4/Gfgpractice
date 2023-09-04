//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair
{
    int x,y;
    Pair(int a,int b)
    {
        x=a;
        y=b;
    }
}
class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int v[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O' && v[i][j]==0)
                {
                    v[i][j]=1;
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    ArrayList<Pair> ar=new ArrayList<>();
                    int f=1;
                    while(!q.isEmpty())
                    {
                        Pair t=q.poll();
                        if(t.x==0 || t.x==(n-1) || t.y==0 || t.y==(m-1))
                        {
                            f=0;
                        }
                        ar.add(t);
                        int dx[]={-1,0,1,0};
                        int dy[]={0,1,0,-1};
                        for(int k=0;k<4;k++)
                        {
                            int l=dx[k]+t.x;
                            int r=dy[k]+t.y;
                            if(l>=0 && l<n && r>=0 && r<m && v[l][r]==0 && a[l][r]=='O')
                            {
                                v[l][r]=1;
                                q.add(new Pair(l,r));
                            }
                        }
                    }
                    if(f==1)
                    {
                        for(Pair k: ar)
                        a[k.x][k.y]='X';
                    }
                }
            }
        }
        return a;
    }
}