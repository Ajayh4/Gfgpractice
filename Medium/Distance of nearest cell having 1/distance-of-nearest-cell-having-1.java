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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    class Pair
    {
        int x,y,d;
        Pair(int x,int y,int d)
        {
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int r=grid.length;
        int c=grid[0].length; 
        int ans[][]=new int[r][c];
        int v[][]=new int[r][c];
        Queue<Pair> q=new LinkedList<Pair>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1)
                {
                    Pair ob=new Pair(i,j,0);
                    q.add(ob);
                    v[i][j]=1;
                }
            }
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair ob=q.poll();
            ans[ob.x][ob.y]=ob.d;
            for(int i=0;i<4;i++)
            {
                if((ob.x+dx[i])>=0 && (ob.x+dx[i])<r && (ob.y+dy[i])>=0 && (ob.y+dy[i])<c && v[ob.x+dx[i]][ob.y+dy[i]]==0)
                {
                    Pair obj=new Pair(ob.x+dx[i],ob.y+dy[i],ob.d+1);
                    v[ob.x+dx[i]][ob.y+dy[i]]=1;
                    q.add(obj);
                }
            }
        }
        return ans;
    }
}