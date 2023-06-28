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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find whether a path exists from the source to destination.
    static boolean ans;
    static void rec(int x,int y,int v[][],int grid[][],int r,int c,int ds,int de)
    {
        v[x][y]=1;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        if(x==ds && y==de)
        ans=true;
        for(int i=0;i<4;i++)
        {
            int p=x+dx[i];
            int q=y+dy[i];
            if(p>=0 && p<r && q>=0 && q<c && v[p][q]==0 && (grid[p][q]==3 || grid[p][q]==2))
            rec(p,q,v,grid,r,c,ds,de);
        }
    }
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        ans=false;
        int r=grid.length,c=grid[0].length;
        int ss=-1,se=-1,ds=-1,de=-1;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1)
                {
                    ss=i;
                    se=j;
                }
                if(grid[i][j]==2)
                {
                    ds=i;
                    de=j;
                }
            }
        }
        int v[][]=new int[r][c];
        rec(ss,se,v,grid,r,c,ds,de);
        return ans;
    }
}