//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                GfG g = new GfG();
                if(g.isSymmetric(root) == true)
                    System.out.println("True");
                else
                    System.out.println("False");
        	
                t--;
            
        }
    }
}



// } Driver Code Ends




/*
class of the node of the tree is as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
// complete this function
// return true/false if the is Symmetric or not
class GfG
{
    public static boolean isSymmetric(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int d=q.size();
            ArrayList<Node> a=new ArrayList<>();
            for(int i=0;i<d;i++)
            {
                Node t=q.poll();
                a.add(t);
                if(t==null)
                {
                    q.add(null);
                    q.add(null);
                }
                else
                {
                    if(t.left!=null)
                    q.add(t.left);
                    else
                    q.add(null);
                    if(t.right!=null)
                    q.add(t.right);
                    else
                    q.add(null);
                }
            }
            if(Collections.frequency(a,null)==a.size())
            break;
            int i=0,j=a.size()-1;
            while(i<j)
            {
                if(a.get(i)==null || a.get(j)==null)
                {
                    if(a.get(i)!=a.get(j))
                    return false;
                }
                else if(a.get(i).data!=a.get(j).data)
                return false;
                i+=1;
                j-=1;
            }
        }
        return true;
    }
}