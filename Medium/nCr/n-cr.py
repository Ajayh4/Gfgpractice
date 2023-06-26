#User function Template for python3

class Solution:
    def nCr(self, n, r):
        # code here
        if n<r:
            return 0
        elif n==r:
            return 1
        l=[1]
        s=1
        for i in range(2,n+1):
            s*=i
            l.append(s)
        ans=l[n-1]//(l[n-r-1]*l[r-1])
        return ans%1000000007


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import sys
sys.setrecursionlimit(10**6)

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n, r = [int(x) for x in input().split()]
        
        ob = Solution()
        print(ob.nCr(n, r))
# } Driver Code Ends