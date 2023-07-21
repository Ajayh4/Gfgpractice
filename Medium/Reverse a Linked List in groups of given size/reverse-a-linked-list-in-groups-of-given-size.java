//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    static void fun(Node h,int k)
    {
        Node t=h;
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<k && t!=null;i++)
        {
            a.add(t.data);
            t=t.next;
        }
        int j=a.size()-1;
        t=h;
        for(int i=0;i<k && t!=null;i++){
        t.data=a.get(j--);
        t=t.next;
        }
    }
    public static Node reverse(Node node, int k)
    {
        //Your code here
        int l=0;
        Node t=node;
        while(t!=null)
        {
            l+=1;
            t=t.next;
        }
        t=node;
        Node t1=node;
        for(int i=0;i<l/k;i++)
        {
            for(int j=1;j<k;j++)
            t1=t1.next;
            fun(t,k);
            //frint(t);
            t1=t1.next;
            t=t1;
        }
        fun(t,k);
        return node;
    }
}

