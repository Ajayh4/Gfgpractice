//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
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
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0]==0  || A[X][Y]==0)
        return -1;
        int v[][]=new int[N][M];
        Queue<Pair> q=new LinkedList<>();
        Pair obj=new Pair(0,0,0);
        v[0][0]=1;
        q.add(obj);
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            int x=t.x;
            int y=t.y;
            int d=t.d;
            if(x==X && y==Y)
            return d;
            for(int j=0;j<4;j++)
            {
                int t1=x+dx[j];
                int t2=y+dy[j];
                if(t1>=0 && t1<N && t2>=0 && t2<M && A[t1][t2]==1 && v[t1][t2]==0)
                {
                    Pair ob=new Pair(t1,t2,d+1);
                    v[t1][t2]=1;
                    q.add(ob);
                }
            }
        }
        return -1;
    }
};