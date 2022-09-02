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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        
        ListNode slow = head, fast = head;
        
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast!=null && fast.next!=null && fast!=slow);
        
        
        if(fast==null || fast.next==null) return false;
        else return true;
    }
}