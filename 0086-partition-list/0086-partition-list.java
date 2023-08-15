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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy_gre = new ListNode(), curr_gre = dummy_gre, curr = head, dummy_less = new ListNode(), curr_less = dummy_less;
        
        while(curr != null){
            if(curr.val<x){
                curr_less.next = curr;
                curr_less = curr;
            }
            else{
                curr_gre.next = curr;
                curr_gre = curr;
            }
            
            curr = curr.next;
        }
        
        curr_less.next = dummy_gre.next;
        curr_gre.next = null;
        
        return dummy_less.next;
    }
}