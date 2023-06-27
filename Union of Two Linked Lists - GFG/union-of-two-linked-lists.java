//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	  
	    //Add your code here.
	   // Node dummy = new Node(0), curr = dummy, c1=head1, c2=head2;
	    
	   // while(c1!=null && c2!=null){
	   //     if(c1.data < c2.data){
	   //         curr.next = c1;
	            
	   //         curr = c1;
	   //         c1 = c1.next;
	   //     }
	   //     else{
	   //         curr.next = c2;
	            
	   //         curr = c2;
	   //         c2 = c2.next;
	   //     }
	   // }
	    
	   // if(c1 != null){
	   //     curr.next = c1;
	   // }
	    
	   // if(c2 != null){
	   //     curr.next = c2;
	   // }
	    
	   // return dummy.next;
	   
	   SortedSet<Integer> sortedSet= new TreeSet<>();
        while (head1!=null){
            sortedSet.add(head1.data);
            head1= head1.next;
        }
        while (head2!=null){
            sortedSet.add(head2.data);
            head2= head2.next;
        }
 
 
        Node newHead= new Node((Integer) sortedSet.first());
        Node newTail= newHead;
        sortedSet.remove(sortedSet.first());
 
        while (!sortedSet.isEmpty()){
            Node x= new Node((Integer) sortedSet.first());
            sortedSet.remove(sortedSet.first());
            newTail.next = x;
            newTail= x;
        }
        return newHead;

	}
}