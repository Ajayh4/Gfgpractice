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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Pair
{
    int x,y;
    Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // code here
        int r=grid.length;
        int c=grid[0].length;
        int v[][]=new int[r][c];
        int ans=0;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(v[i][j]==0 && grid[i][j]=='X')
                {
                    ans+=1;
                    Queue<Pair> q=new LinkedList<>();
                    q.add(new Pair(i,j));
                    v[i][j]=1;
                    while(!q.isEmpty())
                    {
                        Pair t=q.poll();
                        int x=t.x;
                        int y=t.y;
                        for(int k=0;k<4;k++)
                        {
                            int p=x+dx[k];
                            int m=y+dy[k];
                            if(p>=0 && p<r && m>=0 && m<c && v[p][m]==0 && grid[p][m]=='X')
                            {
                                q.add(new Pair(p,m));
                                v[p][m]=1;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}