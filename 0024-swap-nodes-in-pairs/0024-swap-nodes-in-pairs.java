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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        if(dummy.next == null)  return null;
        if(head.next == null)   return head;
        
        solve(dummy, head, head.next);
        return dummy.next;
    }
    
    public void solve(ListNode dummy, ListNode next1, ListNode next2){
        
        dummy.next = next2;
        next1.next = next2.next;
        next2.next = next1;
        
        if(next1.next==null || next1.next.next==null)  return;
        
        solve(next1, next1.next, next1.next.next);
    }
}