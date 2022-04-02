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
        
        if(head == null || head.next == null) return head;
        
        ListNode pre = head,curr = head.next;
        
        return helper(pre,curr);
    }
    
    private ListNode helper(ListNode pre,ListNode curr){
        if(curr.next == null || curr.next.next == null){
            if(curr.next == null){
                curr.next = pre;
                pre.next = null;
                return curr;
            }
            
            pre.next = curr.next;
            curr.next = pre;
            return curr;
        }
        
        pre.next = helper(curr.next,curr.next.next);
        curr.next = pre;
        
        return curr;
    }
}