//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++)
            tail = tail.next = new Node(Integer.parseInt(s[i]));

        return head;
    }

    public static void printList(Node node)
    {
        while (node != null)
        {
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    	System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node head = Node.inputList(br);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            Node res = obj.reverse(head, k);
            
            Node.printList(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node reverse(Node head, int k) {
        // code here
        
        Node to_add_null = head, to_add_last=head;
        
        int temp_k=k;
        while(temp_k-->1)
            to_add_last = to_add_last.next;
        
        Node to_add = to_add_last.next;    
        to_add_last.next = null;    
        
        Node to_return = reverseNode(to_add_null);
        to_add_null.next = reverseNode(to_add);
        
        return to_return;
    }
    
    public static Node reverseNode(Node head){
        Node next=head.next, pre=null, curr = head;
        
        while(next != null){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }        
        
        curr.next = pre;
        
        return curr;
    }
}
        
