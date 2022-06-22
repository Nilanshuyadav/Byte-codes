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
        ListNode curr  = head;
        int len = 1;
        
        if(head == null || head.next == null || k==0) return head;
        
        while(curr.next != null){len++; curr = curr.next;}
        
        k = k%len;
        
        if(k == 0) return head;
        
        curr.next = head;
        
        
        // while(--k>0){
        //     head = head.next;
        // }
        
        for(int i=0;i<len-k-1;i++) head = head.next;
        
        curr = head;
        head = head.next;
        curr.next = null;
        
        return head;
    }
}