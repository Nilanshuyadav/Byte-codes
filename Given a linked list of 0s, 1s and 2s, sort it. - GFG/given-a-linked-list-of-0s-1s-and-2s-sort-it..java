//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        // Node ind=head, one_dummy = new Node(1), one_curr = one_dummy, two_dummy = new Node(2), two_curr = two_dummy, zero_dummy = new Node(0), zero_curr=zero_dummy;
        
        // while(ind!=null){
        //     switch(ind.data){
        //         case 0:
        //             zero_curr.next = ind;
        //             zero_curr = ind;
        //             break;
                
        //         case 1:
        //             one_curr.next = ind;
        //             one_curr = ind;
        //             break;
                    
        //         case 2:
        //             two_curr.next = ind;
        //             two_curr = ind;
        //     }
            
        //     ind = ind.next;
        // }
        
        
        // zero_curr.next = one_dummy.next;
        
        // return zero_dummy.next;
        
        List<Node> arr = new ArrayList();
        
        Node inx=head;
        
        while(inx!=null){
            arr.add(inx);
            
            inx = inx.next;
        }
        
        int n=arr.size(), i=0, j=n-1;
        
        int ind=0;
        
        while(ind<=j){
            if(arr.get(ind).data == 0){
                swap(i, ind, arr);
                i++;
            }
            else if(arr.get(ind).data == 2){
                swap(ind, j, arr);
                j--;
                ind--;
            }
            
            ind++;
        }
        
        Node dummy = new Node(0), curr=dummy;
        
        ind=0;
        while(ind<n){
            curr.next = arr.get(ind);
            curr = curr.next;
            ind++;
        }
        
        curr.next = null;
        
        return dummy.next;
    }
    
    public static void swap(int i, int j, List<Node> arr){
        Node temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}


