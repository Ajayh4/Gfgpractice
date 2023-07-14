//{ Driver Code Starts
import java.util.*;

class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}


class ListToBST
{
    
  /* Function to print linked list */
   public static void preOrder(TNode root)
    {
        
        if(root==null)
            return;
            
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			LNode head = new LNode(sc.nextInt());
            LNode tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new LNode(sc.nextInt());
                tail = tail.next;
            }
		
			Solution obj = new Solution();
			TNode root = obj.sortedListToBST(head);
			preOrder(root);
			
			System.out.println();
			
			t--;
			
         }
    }
}

// } Driver Code Ends


//User function Template for Java

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    static TNode rec(int i,int j,ArrayList<Integer> a)
    {
        if(i>j)
        return null;
        else if(i==j)
        return new TNode(a.get(i));
        else
        {
            int p=(i+j)/2;
            if((i+j)%2==1)
            p+=1;
            TNode tn=new TNode(a.get(p));
            tn.left=rec(i,p-1,a);
            tn.right=rec(p+1,j,a);
            return tn;
        }
    }
    public TNode sortedListToBST(LNode head)
    {
        //code here
        ArrayList<Integer> a=new ArrayList<>();
        while(head!=null)
        {
            a.add(head.data);
            head=head.next;
        }
        TNode tn=rec(0,a.size()-1,a);
        return tn;
    }
}