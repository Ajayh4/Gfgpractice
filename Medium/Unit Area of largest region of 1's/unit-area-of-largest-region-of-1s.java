//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair
{
    int x,y;
    Pair(int a,int b)
    {
        x=a;
        y=b;
    }
}
class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int ans=0;
        int r=grid.length;
        int c=grid[0].length;
        int v[][]=new int[r][c];
        int dx[]={-1,-1,-1,0,0,1,1,1};
        int dy[]={-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1 && v[i][j]==0)
                {
                    int cnt=0;
                    Queue<Pair> q=new LinkedList<>();
                    Pair obj=new Pair(i,j);
                    q.add(obj);
                    v[i][j]=1;
                    while(!q.isEmpty())
                    {
                        cnt+=1;
                        Pair t=q.poll();
                        int x=t.x;
                        int y=t.y;
                        for(int k=0;k<8;k++)
                        {
                            int p=x+dx[k];
                            int m=y+dy[k];
                            if(p>=0 && p<r && m>=0 && m<c && v[p][m]==0 && grid[p][m]==1)
                            {
                                Pair ob=new Pair(p,m);
                                q.add(ob);
                                v[p][m]=1;
                            }
                        }
                    }
                    ans=Math.max(ans,cnt);
                }
            }
        }
        return ans;
    }
}