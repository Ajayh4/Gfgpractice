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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
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
    static boolean rec(int i,int j,int r,int c,char board[][],int v[][],int cnt,String word)
    {
        if(cnt==word.length())
        return true;
        else
        {
            boolean ans=false;
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};
            for(int k=0;k<4;k++)
            {
                int l=i+dx[k];
                int m=j+dy[k];
                if(l>=0 && l<r && m>=0 && m<c && v[l][m]==0 && board[l][m]==word.charAt(cnt))
                {
                    v[l][m]=1;
                    ans=ans||(rec(l,m,r,c,board,v,cnt+1,word));
                    if(ans)
                    break;
                    v[l][m]=0;
                }
            }
            return ans;
        }
    }
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int r=board.length,c=board[0].length;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    int v[][]=new int[r][c];
                    v[i][j]=1;
                    if(rec(i,j,r,c,board,v,1,word))
                    return true;
                }
            }
        }
        return false;
    }
}