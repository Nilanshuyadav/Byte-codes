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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k==1) return head;
        
        ListNode curr = head, nex = curr.next, dummy = new ListNode(),pre = dummy;
        
        dummy.next = head;
        
        int count = 0,n = k;
        
        while(curr != null){
            count++;
            curr = curr.next;
        }
        
        curr = head;
        
        while(count >= k){
            
            curr = pre.next;
            nex = curr.next;
            
            while(n-->1){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            
            count -= k;
            pre = curr;
            
            n = k;
        }
        
        return dummy.next;
    }
}