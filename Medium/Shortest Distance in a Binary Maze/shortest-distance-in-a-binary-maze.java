//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
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
    int shortestPath(int[][] grid, int[] s, int[] d) {
        int r=grid.length;
        int c=grid[0].length;
        int v[][]=new int[r][c];
        int ans=0;
        if(grid[s[0]][s[1]]==0 || grid[d[0]][d[1]]==0)
        return -1;
        Queue<Pair> q=new LinkedList<>();
        v[s[0]][s[1]]=1;
        q.add(new Pair(s[0],s[1]));
        while(!q.isEmpty())
        {
            int ds=q.size();
            for(int k=0;k<ds;k++)
            {
                Pair t=q.poll();
                if(t.x==d[0] && t.y==d[1])
                return ans;
                int l=t.x;
                int m=t.y;
                int dx[]={-1,0,1,0};
                int dy[]={0,1,0,-1};
                for(int i=0;i<4;i++)
                {
                    int x=l+dx[i];
                    int y=m+dy[i];
                    if(x>=0 && x<r && y>=0 && y<c && grid[x][y]==1 && v[x][y]==0)
                    {
                        q.add(new Pair(x,y));
                        v[x][y]=1;
                    }
                }
            }
            ans+=1;
        }
        return -1;
    }
}
