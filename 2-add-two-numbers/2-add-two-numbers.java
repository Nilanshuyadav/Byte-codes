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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        ListNode ptr1 = l1, ptr2 = l2;
        int sum = 0,carry = 0;
        
        while(ptr1 != null && ptr2 != null){
            sum = ptr1.val + ptr2.val + carry;
            
            ListNode temp = new ListNode(sum%10);
            curr.next = temp;
            curr = curr.next;
            
            carry = sum/10;
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        while(ptr1 != null){
            sum = ptr1.val + carry;
            
            ListNode temp = new ListNode(sum%10);
            curr.next = temp;
            curr = curr.next;
            
            carry = sum/10;
            ptr1 = ptr1.next;
        }
        
        while(ptr2 != null){
            sum = ptr2.val + carry;
            
            ListNode temp = new ListNode(sum%10);
            curr.next = temp;
            curr = curr.next;
            
            carry = sum/10;
            ptr2 = ptr2.next;
        }
        
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            curr.next = temp;
        }
        
        return dummy.next;
    }
}