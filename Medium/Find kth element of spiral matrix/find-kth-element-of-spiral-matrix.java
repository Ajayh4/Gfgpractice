//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
        int d=0,l=0,r=m-1,t=0,b=n-1,c=0;
        while(l<=r && t<=b)
        {
            if(d==0)
            {
                for(int i=l;i<=r;i++)
                {
                    c+=1;
                    if(c==k)
                    return A[t][i];
                }
                t+=1;
            }
            else if(d==1)
            {
                for(int i=t;i<=b;i++)
                {
                    c+=1;
                    if(c==k)
                    return A[i][r];
                }
                r-=1;
            }
            else if(d==2)
            {
                for(int i=r;i>=l;i--)
                {
                    c+=1;
                    if(c==k)
                    return A[b][i];
                }
                b-=1;
            }
            else
            {
                for(int i=b;i>=t;i--)
                {
                    c+=1;
                    if(c==k)
                    return A[i][l];
                }
                l+=1;
            }
            d=(d+1)%4;
        }
        return 0;
    }
}