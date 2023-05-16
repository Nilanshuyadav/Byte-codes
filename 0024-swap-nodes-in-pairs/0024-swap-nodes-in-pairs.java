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
        ListNode dummy = new ListNode(), toReturn = dummy, next1, next2;
        dummy.next = head;
        
        while(dummy.next!=null && dummy.next.next!=null){
            next1 = dummy.next;
            next2 = dummy.next.next;
            
            dummy.next = next2;
            next1.next = next2.next;
            next2.next = next1;
            
            dummy = next1;
        }
        
        return toReturn.next;
    }
    
    public void solve(ListNode dummy, ListNode next1, ListNode next2){
        
        dummy.next = next2;
        next1.next = next2.next;
        next2.next = next1;
        
        if(next1.next==null || next1.next.next==null)  return;
        
        solve(next1, next1.next, next1.next.next);
    }
}