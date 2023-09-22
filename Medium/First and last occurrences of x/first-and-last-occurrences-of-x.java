//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        int ind=Arrays.binarySearch(arr,x);
        if(ind<0)
        {
            a.add(-1);
            a.add(-1);
            return a;
        }
        int p=ind,q=ind;
        if(p-1>=0 && arr[p-1]==arr[ind])
        {
            p=ind-1;
            while(p>=0 && arr[ind]==arr[p])
            {
                p-=1;
            }
            p+=1;
        }
        if(q+1<n && arr[q+1]==arr[ind])
        {
            q=ind+1;
            while(q<n && arr[ind]==arr[q])
            {
                q+=1;
            }
            q-=1;
        }
        a.add(p);
        a.add(q);
        return a;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends