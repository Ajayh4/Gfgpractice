//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static HashSet<String> res;
    static void dfs(int x,int y,int v[][],String r,String s,int s1,int s2,char grid[][],int ind)
    {
        v[x][y]=1;
        if(ind>=s.length())
        {
            if(r.compareTo(s)==0)
            res.add(r);
            return;
        }
        int dx[]={-1,-1,-1,0,0,1,1,1};
        int dy[]={-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<8;i++)
        {
            int ax=x+dx[i];
            int ay=y+dy[i];
            if(ax>=0 && ax<s1 && ay>=0 && ay<s2 && v[ax][ay]==0 && grid[ax][ay]==s.charAt(ind))
            {
                dfs(ax,ay,v,r+grid[ax][ay],s,s1,s2,grid,ind+1);
            }
        }
        v[x][y]=0;
    }
    public String[] wordBoggle(char grid[][], String[] dictionary)
    {
        // Write your code here
        res=new HashSet<>();
        int s1=grid.length;
        int s2=grid[0].length;
        int v[][]=new int[s1][s2];
        for(String i: dictionary)
        {
            for(int j=0;j<s1;j++)
            {
                for(int k=0;k<s2;k++)
                {
                    if(grid[j][k]==i.charAt(0))
                    {
                        dfs(j,k,v,i.charAt(0)+"",i,s1,s2,grid,1);
                        v=new int[s1][s2];
                    }
                }
            }
        }
        String r[]=new String[res.size()];
        int j=0;
        for(String i: res)
        r[j++]=i;
        return r;
    }
}