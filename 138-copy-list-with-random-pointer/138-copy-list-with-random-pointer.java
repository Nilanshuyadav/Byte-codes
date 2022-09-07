/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node curr = head;
        
        while(curr!=null){
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr!=null){
            if(curr.random==null) curr.next.random = null;
            else curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
 
        curr = head;
        Node dummy = head.next, curr_copy = dummy;
        
        while(curr_copy.next!=null){
            curr.next = curr.next.next;
            curr_copy.next = curr_copy.next.next;
            curr = curr.next;
            curr_copy = curr_copy.next;
        }
 
        curr.next = null;
        return dummy;
    }
}