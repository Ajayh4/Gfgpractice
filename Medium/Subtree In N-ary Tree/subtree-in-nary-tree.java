//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            N_ary_Tree tree = new N_ary_Tree();
            Node curr = null;
            Queue<Node> q = new LinkedList<>();
            for(int i = 0; i < s.length; i++){
                if(i == 0){
                    curr = tree.add(Integer.parseInt(s[0]), null);
                } else if(s[i].equals(" ")){
                    continue;
                } else if(!q.isEmpty() && s[i].equals("N")){
                    curr = q.remove();
                } else if(!s[i].equals("N")){
                    q.add(tree.add(Integer.parseInt(s[i]), curr));
                }
            }
            Solution soln = new Solution();
            ot.println(soln.duplicateSubtreeNaryTree(tree.root));
        }

        ot.close();
    }
}
class Node{
    int data;
    List<Node> children;
    Node(int val){
        this.data = val;
        this.children = new ArrayList<>();
    }
}
class N_ary_Tree{
    Node root;
    int size;
    N_ary_Tree(){
        this.size = 0;
        this.root = null;
    }
    Node add(int key, Node parent){
        Node node = new Node(key);
        if(parent == null){
            this.root = node;
            this.size = 1;
        } else{
            parent.children.add(node);
            this.size++;
        }
        return node;
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    static ArrayList<Integer> a;
    static HashMap<Integer,ArrayList<ArrayList<Integer>>> hm;
    static HashSet<ArrayList<Integer>> hs;
    static int ans;
    static void fun(Node root)
    {
        if(root==null)
        return;
        a.add(root.data);
        for(int i=0;i<root.children.size();i++)
        fun(root.children.get(i));
    }
    static void rec(Node root)
    {
        if(root==null)
        return;
        a=new ArrayList<Integer>();
        fun(root);
        if(hm.containsKey(root.data))
        {
            int f=1;
            ArrayList<ArrayList<Integer>> res=hm.get(root.data);
            for(ArrayList<Integer> ar: res)
            {
                if(ar.equals(a))
                {
                    f=0;
                    if(!hs.contains(a))
                    {
                        ans+=1;
                        hs.add(a);
                        break;
                    }
                }
            }
            if(f==1)
            res.add(a);
        }
        else
        {
            ArrayList<ArrayList<Integer>> res=new ArrayList<>();
            res.add(a);
            hm.put(root.data,res);
        }
        for(int i=0;i<root.children.size();i++)
        rec(root.children.get(i));
    }
    public int duplicateSubtreeNaryTree(Node root){
        ans=0;
        hm=new HashMap<>();
        hs=new HashSet<>();
        rec(root);
        return ans;
    }
    
}