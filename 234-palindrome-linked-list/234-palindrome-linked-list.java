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
        ListNode slow = head, fast = head;
        if(head.next == null) return true;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast!=null && fast.next!=null);
        
        if(fast == null){
            fast = head;
            while(fast.next != slow) fast = fast.next;
        }
        else fast = slow;
        
        fast.next = reverse(fast.next);
        fast = fast.next;
        slow = head;
        
        while(fast!=null){
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null,curr = head,next = head.next;
        while(next != null){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = pre;
        return curr;
    }
}