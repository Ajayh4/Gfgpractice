//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    static Stack<Integer> st;
    static void adds(int v)
    {
        if(st.isEmpty())
        {
            st.add(v);
            return;
        }
        else
        {
            int a=st.pop();
            if(v>a)
            {
                st.add(a);
                st.add(v);
            }
            else
            {
                adds(v);
                st.add(a);
            }
        }
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		st=new Stack<>();
		while(!s.isEmpty())
		{
		    int v=s.pop();
		    adds(v);
		}
		return st;
	}
}