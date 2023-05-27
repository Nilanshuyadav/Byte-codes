//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
        if(head == null) return null;
        
        Node slow = head, fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node j = reverse(slow, slow.next, null);
        Node i = head;
        
        Node r = j;
        int temp;
        
        while(true && i!=j){
            temp = i.data;
            i.data = j.data-temp;
            j.data = temp;
            
            if(i.next == j){
                break;
            }
            
            i = i.next;
            j = j.next;
        }
        
        i.next = reverse(null, r, i);
        
        return head;
    }
    
    public static Node reverse(Node pre, Node curr, Node stop){
        Node nex = curr.next;
        
        while(curr != stop){
            nex = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nex;
        }
        
        return pre;
    }
}