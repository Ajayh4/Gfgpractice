//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Pair
{
    int x,y,d;
    Pair(int a,int b,int c)
    {
        x=a;
        y=b;
        d=c;
    }
}
class Solution {
    int MinimumEffort(int he[][]) {
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b) -> a.d-b.d);
        int r=he.length;
        int c=he[0].length;
        q.add(new Pair(0,0,0));
        int ans=-1;
        int sp[][]=new int[r][c];
        for(int i[]: sp)
        Arrays.fill(i,Integer.MAX_VALUE);
        sp[0][0]=0;
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};
            if(t.x==r-1 && t.y==c-1)
            {
                if(ans==-1)
                ans=t.d;
                else
                ans=Math.min(t.d,ans);
            }
            for(int i=0;i<4;i++)
            {
                int a=t.x+dx[i];
                int b=t.y+dy[i];
                if(a>=0 && a<r && b>=0 && b<c)
                {
                    int ne=Math.max(t.d,Math.abs(he[a][b]-he[t.x][t.y]));
                    if(ne<sp[a][b])
                    {
                        sp[a][b]=ne;
                        q.add(new Pair(a,b,ne));
                    }
                }
            }
        }
        return ans;
    }
}