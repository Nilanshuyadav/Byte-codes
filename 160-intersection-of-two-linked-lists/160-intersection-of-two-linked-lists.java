/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        boolean a=true,b=true;
        
        while(l1 != l2){
            if(l1.next==null && a){l1 = headB; a = false;}
            else l1 = l1.next;
            
            if(l2.next==null && b){l2 = headA; b = false;}
            else l2 = l2.next;
        }
        return l1;
    }
}