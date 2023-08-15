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
      int a[][] = new int[n][2];
      for(int i=0;i<n;i++){
        a[i][0]=sc.nextInt();
        a[i][1]=sc.nextInt();
      }
      int h[]=new int[2];
      h[0]=sc.nextInt();
      h[1]=sc.nextInt();
      Solution obj = new Solution();
      int ans[][] = obj.insertNewEvent(n,a,h);
      System.out.print("[");
      for(int i=0;i<ans.length;i++)
       {
           System.out.print("[");
           System.out.print(ans[i][0]+","+ans[i][1]);
           System.out.print("]");
           if(i!=ans.length-1)
           System.out.print(",");
       }
      System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[][] insertNewEvent(int n,int[][] intervals, int[] newInterval) {
    // code here
    ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i[]:intervals)
        {
            ArrayList<Integer> t=new ArrayList<>();
            t.add(i[0]);
            t.add(i[1]);
            a.add(t);
        }
        if(intervals.length==0)
        {
            int res[][]=new int[1][2];
            res[0][0]=newInterval[0];
            res[0][1]=newInterval[1];
            return res;
        }
        ArrayList<Integer> ni=new ArrayList<>();
        ni.add(newInterval[0]);
        ni.add(newInterval[1]);
        int f=1,c=0;
        for(ArrayList<Integer> i: a)
        {
            if(i.get(0)>ni.get(0))
            {
                a.add(c,ni);
                f=0;
                break;
            }
            c+=1;
        }
        if(f==1)
        a.add(c,ni);
        //System.out.println(a);
        ArrayList<ArrayList<Integer>> tp=new ArrayList<>();
        tp.add(a.get(0));
        for(int i=1;i<a.size();i++)
        {
            int x=tp.size()-1;
            ArrayList<Integer> l=tp.get(x);
            ArrayList<Integer> r=a.get(i);
            if(l.get(1)<r.get(0))
            {
                ArrayList<Integer> tep=new ArrayList<>();
                tep.add(r.get(0));
                tep.add(r.get(1));
                tp.add(tep);
            }
            else if(l.get(0)<=r.get(0))
            {
                if(l.get(1)<=r.get(1))
                tp.get(x).set(1,r.get(1));
            }
            else
            {
                tp.get(x).set(0,r.get(0));
                if(l.get(1)<=r.get(1))
                tp.get(x).set(1,r.get(1));
            }
            //System.out.println(tp);
        }
        int res[][]=new int[tp.size()][2];
        for(int i=0;i<tp.size();i++)
        {
            res[i][0]=tp.get(i).get(0);
            res[i][1]=tp.get(i).get(1);
        }
        return res;
  }
}
     