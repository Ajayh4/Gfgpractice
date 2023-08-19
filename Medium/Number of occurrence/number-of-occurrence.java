//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int ins=Arrays.binarySearch(arr,x);
        if(ins<0)
        return 0;
        else
        {
            int c=1;
            int t=ins-1;
            while(t>=0)
            {
                if(arr[t]==x)
                {
                    c+=1;
                    t-=1;
                }
                else
                break;
            }
            t=ins+1;
            while(t<n)
            {
                if(arr[t]==x)
                {
                    c+=1;
                    t+=1;
                }
                else
                break;
            }
            return c;
        }
    }
}