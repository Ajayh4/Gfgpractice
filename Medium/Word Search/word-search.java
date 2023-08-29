//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      char a[][] = new char[n][m];
      sc.nextLine();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++)
         a[i][j]=sc.next().charAt(0);
      }
      String word=sc.next();
      Solution obj = new Solution();
      int ans = obj.wordSearch(a,word) ? 1 : 0;
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
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
  public static boolean wordSearch(char board[][],String word) {
    // code here
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
     