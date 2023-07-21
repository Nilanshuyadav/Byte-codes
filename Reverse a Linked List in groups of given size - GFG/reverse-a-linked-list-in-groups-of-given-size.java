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
    public static Node reverse(Node node, int k)
    {
        //Your code here
        if(node.next == null)   return node;
        Node returned[], curr=node, ans=null, pre=null;
        
        while(curr!=null){
            returned = reverse(null, curr, k);
            
            if(pre==null){
                ans = returned[0];
            }
            else{
                pre.next = returned[0];
            }
            
            pre = curr;
            curr = returned[1];
        }
        
        return ans;
    }
    
    public static Node[] reverse(Node pre, Node curr, int k){
        Node next;
        
        next = curr.next;
        
        while(k-->1 && next!=null){
            curr.next = pre;
            
            pre = curr;
            curr = next;
            next = curr.next;
        }
        
        curr.next = pre;
        
        return new Node[]{curr, next};
    }
}

