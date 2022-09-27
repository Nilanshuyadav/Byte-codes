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
        ListNode pre=null, curr=head, next=head.next;
        
        while(next!=null){
            curr.next=pre;
            pre = curr;
            curr = next;
            next = curr.next;
        }
        
        curr.next = pre;
        return curr;
    }
}