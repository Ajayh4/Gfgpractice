//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static boolean ans;
    static void dfs(int p,int q,char grid[][],int v[][],String word,int cnt,String dir)
    {
        int dx[]={-1,-1,-1,0,1,1,1,0};
        int dy[]={-1,0,1,1,1,0,-1,-1};
        for(int i=0;i<8;i++)
        {
            int x=p+dx[i];
            int y=q+dy[i];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && word.charAt(cnt)==grid[x][y] && v[x][y]==0)
            {
                int mc=1;
                while(x>=0 && x<grid.length && y>=0 && y<grid[0].length && word.charAt(mc)==grid[x][y] && v[x][y]==0)
                {
                    mc+=1;
                    if(word.length()==mc)
                    {
                        ans=true;
                        break;
                    }
                    x+=dx[i];
                    y+=dy[i];
                }
            }   
        }
    }
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        int r=grid.length,c=grid[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==word.charAt(0))
                {
                    int v[][]=new int[r][c];
                    v[i][j]=1;
                    ans=false;
                    if(word.length()==1)
                    {
                        ArrayList<Integer> ar=new ArrayList<>();
                        ar.add(i);
                        ar.add(j);
                        a.add(ar);
                    }
                    else{
                    dfs(i,j,grid,v,word,1,"");
                    if(ans)
                    {
                        ArrayList<Integer> ar=new ArrayList<>();
                        ar.add(i);
                        ar.add(j);
                        a.add(ar);
                    }
                    }
                }
            }
        }
        int s=a.size(),cnt=0;
        int res[][]=new int[s][2];
        for(ArrayList<Integer> x: a)
        {
            res[cnt][0]=x.get(0);
            res[cnt][1]=x.get(1);
            cnt+=1;
        }
        return res;
    }
}