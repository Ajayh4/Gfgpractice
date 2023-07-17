//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
		string FirstNonRepeating(string A){
		    // Code here
		    string res="";
        int j=0;
        string m="";
        int a[26]={0};
        for(int i=0;i<A.size();i++)
        {
            a[A[i]-'a']+=1;
            if(a[A[i]-'a']==1)
            m+=A[i];
            int s=m.size();
            int f=1;
            for(int k=j;k<s;k++)
            {
                if(a[m[k]-'a']==1)
                {
                    res+=m[k];
                    f=0;
                    break;
                }
                j+=1;
            }
            if(f==1)
            res+='#';
        }
        return res;
		}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string A;
		cin >> A;
		Solution obj;
		string ans = obj.FirstNonRepeating(A);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends