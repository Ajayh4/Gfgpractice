#User function Template for python3

class Solution:
    def largestPrimeFactor (self, n):
        # code here
        def prim(n):
            if n<=1:
                return False
            for i in range(2,int(n**0.5)+1):
                if n%i==0:
                    return False
            return True
        l=[]
        for i in range(1,int(n**0.5)+1):
            if n%i==0:
                if prim(n//i):
                    return n//i
                else:
                    l.append(i)
        for i in l[::-1]:
            if prim(i):
                return i
        return -1
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
       

        ob = Solution()
        print(ob.largestPrimeFactor(N))
# } Driver Code Ends