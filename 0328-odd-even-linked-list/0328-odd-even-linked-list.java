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
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(), odd = new ListNode(), even_curr = even, odd_curr = odd;
        ListNode curr = head;
        
        boolean odd_ind = true;
        
        while(curr != null){
            if(odd_ind){
                odd_curr.next = curr;
                odd_curr = curr;
            }
            else{
                even_curr.next = curr;
                even_curr = curr;
            }
            
            curr = curr.next;
            odd_ind = !odd_ind;
        }
        
        odd_curr.next = even.next;
        even_curr.next = null;
        
        return odd.next;
    }
}