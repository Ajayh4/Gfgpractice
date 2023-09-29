//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
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

    int numberOfEnclaves(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int v[][]=new int[r][c];
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1 && v[i][j]==0)
                {
                    q.add(new Pair(i,j));
                    v[i][j]=1;
                    int cnt=0,f=1;
                    while(!q.isEmpty())
                    {
                        int dx[]={0,-1,0,1};
                        int dy[]={1,0,-1,0};
                        Pair t=q.poll();
                        cnt+=1;
                        if(t.x==0 || t.x==(r-1) || t.y==0 || t.y==(c-1))
                        {
                            f=0;
                        }
                        for(int k=0;k<4;k++)
                        {
                            int l=t.x+dx[k];
                            int m=t.y+dy[k];
                            if(l>=0 && l<r && m>=0 && m<c && v[l][m]==0 && grid[l][m]==1)
                            {
                                v[l][m]=1;
                                q.add(new Pair(l,m));
                            }
                        }
                    }
                    if(f==1)
                    ans+=cnt;
                }
            }
        }
        return ans;
    }
}