//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
        Node curr = head;
        
        int nearestPrime;
        while(curr != null){
            nearestPrime = nearestPrime(curr.val);
            
            curr.val = nearestPrime;
            curr = curr.next;
        }
        
        return head;
    }
    
    int nearestPrime(int val){
        if(val == 1)
            return 2;
            
        if(isPrime(val))
            return val;
        
        int left_prime=-1, right_prime=-1, left_curr=val-1, right_curr=val+1;
        while(left_prime==-1 && right_prime==-1){
            if(isPrime(left_curr))
                left_prime = left_curr;
                
            if(isPrime(right_curr))
                right_prime = right_curr;
            
            left_curr--;
            right_curr++;
        }    
        
        if(left_prime!=-1)
            return left_prime;
            
        return right_prime;    
    }
    
    boolean isPrime(int val){
        for(int ind=2; ind<=(int)Math.sqrt(val); ind++){
            if(val%ind == 0)
                return false;
        }
        
        return true;
    }
}