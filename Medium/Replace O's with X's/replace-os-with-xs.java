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
    static char[][] fill(int r, int c, char a[][])
    {
        // code here
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int v[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[i][j]=='O' && v[i][j]==0)
                {
                    Pair ob=new Pair(i,j);
                    Queue<Pair> q=new LinkedList<>();
                    q.add(ob);
                    int f=1;
                    ArrayList<Pair> ar=new ArrayList<>();
                    while(!q.isEmpty())
                    {
                        Pair t=q.poll();
                        int l=t.x;
                        int m=t.y;
                        ar.add(t);
                        if(l==0 || l==(r-1) || m==0 || m==(c-1))
                        f=0;
                        for(int k=0;k<4;k++)
                        {
                            int s=l+dx[k];
                            int e=m+dy[k];
                            if(s>=0 && s<r && e>=0 && e<c && a[s][e]=='O' && v[s][e]==0)
                            {
                                Pair tem=new Pair(s,e);
                                q.add(tem);
                                v[s][e]=1;
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