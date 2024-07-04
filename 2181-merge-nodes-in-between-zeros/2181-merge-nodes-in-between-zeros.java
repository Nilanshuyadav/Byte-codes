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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(), curr = head.next, pre = dummy;
        
        int sum = 0;
        while(curr!=null){
            sum += curr.val;
            
            if(curr.val == 0){
                pre.next = new ListNode(sum);
                pre = pre.next;
                sum = 0;
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}