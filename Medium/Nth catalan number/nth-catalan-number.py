
class Solution:
    def findCatalan(self, n : int) -> int:
        # code here
        l=[1]
        s=1
        for i in range(2,2*n+3):
            s*=i
            l.append(s)
        return (l[2*n-1]//(l[n]*l[n-1]))%1000000007
        



#{ 
 # Driver Code Starts
if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        obj = Solution()
        res = obj.findCatalan(n)
        
        print(res)
        

# } Driver Code Ends