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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode curr = head;
        int len = 1;
        while(curr.next != null) {len++; curr = curr.next;}
        
        k = k%len;
        curr.next = head;
        
        len = len-k-1;
        curr = head;
        while(len-->0) curr = curr.next;
        
        head = curr.next;
        curr.next = null;
        
        return head;
    }
}