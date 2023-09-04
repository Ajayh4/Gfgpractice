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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair
{
    int x,y,w;
    Pair(int a,int b,int c)
    {
        x=a;
        y=b;
        w=c;
    }
}
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int r=grid.length;
        int c=grid[0].length;
        int sp[][]=new int[r][c];
        sp[0][0]=grid[0][0];
        for(int i[]: sp)
        Arrays.fill(i,-1);
        PriorityQueue<Pair> q=new PriorityQueue<>((x,y) -> Integer.compare(x.w,y.w));
        q.add(new Pair(0,0,grid[0][0]));
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};
            if(t.x==(r-1) && t.y==(c-1))
            break;
            for(int j=0;j<4;j++)
            {
                int nx=t.x+dx[j];
                int ny=t.y+dy[j];
                if(nx>=0 && nx<r && ny>=0 && ny<c)
                {
                    if(sp[nx][ny]==-1){
                    q.add(new Pair(nx,ny,t.w+grid[nx][ny]));
                    sp[nx][ny]=t.w+grid[nx][ny];
                    }
                    else if(grid[nx][ny]+t.w<sp[nx][ny]){
                        q.add(new Pair(nx,ny,t.w+grid[nx][ny]));
                        sp[nx][ny]=t.w+grid[nx][ny];
                    }
                }
            }
        }
        // for(int i[]: sp)
        // System.out.println(Arrays.toString(i));
        return sp[r-1][c-1];
    }
}