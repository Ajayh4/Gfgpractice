//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair
    {
        int x,y;
        Pair(int a,int b)
        {
            x=a;
            y=b;
        }
    }
    int numberOfEnclaves(int[][] grid) {
        // Your code here
        int r=grid.length;
        int c=grid[0].length;
        int ans=0;
        int v[][]=new int[r][c];
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1 && v[i][j]==0){
                    Queue<Pair> q=new LinkedList<>();
                    Pair obj=new Pair(i,j);
                    q.add(obj);
                    int x=0,f=1;
                    v[i][j]=1;
                    while(!q.isEmpty())
                    {
                        Pair t=q.poll();
                        int l=t.x;
                        int m=t.y;
                        if(l==0 || l==(r-1) || m==0 || m==(c-1))
                        f=0;
                        x+=1;
                        for(int k=0;k<4;k++)
                        {
                            int p=l+dx[k];
                            int s=m+dy[k];
                            if(p>=0 && p<r && s>=0 && s<c && grid[p][s]==1 && v[p][s]==0)
                            {
                                Pair tem=new Pair(p,s);
                                q.add(tem);
                                v[p][s]=1;
                            }
                        }
                    }
                    if(f==1)
                    {
                        ans+=x;
                    }
                }
            }
        }
        return ans;
    }
}