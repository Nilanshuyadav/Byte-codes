/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head, fast = head;
        
        if(head==null || head.next==null) return null;
        
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast!=null && fast.next!=null && fast!=slow);
        
        if(fast==null || fast.next==null) return null;
        
        fast = head;
        
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}