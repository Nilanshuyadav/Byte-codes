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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        
        ListNode curr = head;
        int len = 0;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        
        if(len==n) return head.next;
        
        curr = head;
        int k = len-n;
        while(k-->1){
            curr = curr.next;
        }
        
        curr.next = curr.next.next;
        return head;
    }
}