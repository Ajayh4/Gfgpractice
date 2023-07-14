//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        if(n==1 || n==2)
        return 1;
        int x=1,y=1,z=0;
        n-=2;
        int  m=1000000007;
        while(n>0)
        {
            z=((x%m)+(y%m))%m;
            x=y;
            y=z;
            n-=1;
        }
        return z;
    }
}