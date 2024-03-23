/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode r = reverse(slow.next), l = head, dummy = new ListNode(-1), curr = dummy;
        
        while(l!=null && r!=null){
            curr.next = l;
            
            curr = l;
            l = l.next;
            
            curr.next = r;
            curr = r;
            r = r.next;
        }
        
        if(l!=null)
        {
            curr.next = l;
            l.next = null;        
        }    
    }
    
    public ListNode reverse(ListNode curr){
        if(curr == null) return curr;
        
        ListNode pre=null, next = curr.next;
        
        while(next!=null){
            curr.next = pre;
            
            pre = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = pre;
        return curr;
    }
}