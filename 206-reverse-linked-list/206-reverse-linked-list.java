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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        return dfs(null, head, head.next);
    }
    
    public ListNode dfs(ListNode pre, ListNode curr, ListNode next){
        if(next==null){
            curr.next = pre;
            return curr;
        }
        curr.next = pre;
        
        return dfs(curr,next,next.next);
    }
}