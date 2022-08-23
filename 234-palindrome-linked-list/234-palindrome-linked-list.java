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
    public boolean isPalindrome(ListNode head) {
        ListNode head2 = reverse(head);
        
        while(head != null){
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null, curr = new ListNode(head.val),next = head.next;
        while(next != null){
            curr.next = pre;
            pre = curr;
            curr = new ListNode(next.val);
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }
}