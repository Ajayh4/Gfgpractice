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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

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
class Solution
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int v[][]=new int[N][N];
        Pair obj=new Pair(KnightPos[0]-1,KnightPos[1]-1,0);
        Queue<Pair> q=new LinkedList<>();
        q.add(obj);
        v[KnightPos[0]-1][KnightPos[1]-1]=1;
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            int x=t.x;
            int y=t.y;
            if(x==(TargetPos[0]-1) && y==(TargetPos[1]-1))
            return t.d;
            int dx[]={-1,-2,-2,-1,1,2,2,1};
            int dy[]={-2,-1,1,2,-2,-1,1,2};
            for(int i=0;i<8;i++)
            {
                int p=x+dx[i];
                int r=y+dy[i];
                if(p>=0 && p<N && r>=0 && r<N && v[p][r]==0)
                {
                    v[p][r]=1;
                    Pair ob=new Pair(p,r,t.d+1);
                    q.add(ob);
                }
            }
        }
        return -1;
    }
}