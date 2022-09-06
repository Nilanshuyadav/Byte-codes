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
        if(head.next==null) return head;
        ListNode dummy = new ListNode(), pre = dummy, curr = head, nex = head.next;
        pre.next = head;
        int cnt = 0,n = k;
        while(curr != null){
            cnt++;
            curr = curr.next;
        }
        
        curr = head;
        
        while(cnt>=k){
            curr = pre.next;
            nex = curr.next;
            
            while(n-->1){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            
            pre = curr;
            cnt -= k;
            n=k;
        }
        return dummy.next;
    }
}