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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head),end = head,start = dummy;
        
        while(left-- >1)
            start = start.next;
        
        while(right-- > 0) end = end.next;
        
        ListNode pre = end,curr = start.next,next = curr.next;
        
        while(next != end){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = pre;
        start.next = curr;
        
        return dummy.next;
    }
}