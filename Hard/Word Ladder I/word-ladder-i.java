//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair
{
    String s;
    int c;
    Pair(String t,int d)
    {
        s=t;
        c=d;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord,1));
        HashSet<String> hs=new HashSet<>();
        for(String i: wordList)
        hs.add(i);
        if(!hs.contains(targetWord))
        return 0;
        while(!q.isEmpty())
        {
            Pair t=q.poll();
            String s=t.s;
            int c=t.c;
            if(s.compareTo(targetWord)==0)
            return c;
            for(int i=0;i<s.length();i++)
            {
                char p=s.charAt(i);
                for(int j=0;j<26;j++)
                {
                    if(p!=(char)('a'+j))
                    {
                        String temp=s.substring(0,i);
                        temp+=(char)('a'+j);
                        temp+=s.substring(i+1,s.length());
                        if(hs.contains(temp))
                        {
                            q.add(new Pair(temp,c+1));
                            hs.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}