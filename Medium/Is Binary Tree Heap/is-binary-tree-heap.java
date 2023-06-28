//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

  public class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    static boolean rec(Node head)
    {
        if(head!=null && head.left!=null)
        {
            if(head.data<head.left.data)
            return false;
        }
        else
        return true;
        if(head!=null && head.right!=null)
        {
            if(head.data<head.right.data)
            return false;
        }
        else
        return true;
        return rec(head.left)&&rec(head.right);
    }
    boolean isHeap(Node tree) {
        // code here
        Queue<Node> q=new LinkedList<>();
        q.add(tree);
        ArrayList<Integer> a=new ArrayList<>();
        while(!q.isEmpty())
        {
            int d=q.size();
            a.add(d);
            int f=1;
            for(int i=0;i<d;i++)
            {
                Node t=q.poll();
                if(t.left!=null)
                {
                    if(f==0)
                    return false;
                    q.add(t.left);
                }
                else
                f=0;
                if(t.right!=null)
                {
                    if(f==0)
                    return false;
                    q.add(t.right);
                }
                else
                f=0;
            }
        }
        for(int i=0;i<a.size()-1;i++)
        {
            if(a.get(i)!=Math.pow(2,i))
            return false;
        }
        return rec(tree);
    }
}