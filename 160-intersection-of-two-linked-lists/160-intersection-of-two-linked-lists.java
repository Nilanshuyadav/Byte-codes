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
        int lenA = 0;
        int lenB = 0;
        
        ListNode lA = headA, lB = headB;
        
        while(headA != null){
            lenA++;
            headA = headA.next;
        }
        
        while(headB != null){
            lenB++;
            headB = headB.next;
        }
        
        int diff = Math.abs(lenA-lenB);
        
        headA = lA;
        headB = lB;
        
        if(lenA>lenB){
            while(diff-->0)
                lA = lA.next;
        }
        
        else{
            while(diff-->0)
                lB = lB.next;
        }
        
        while(lA != lB && lA != null && lB != null){
            lA = lA.next;
            lB = lB.next;
        }
        
        if(lA == null || lB == null) return null;
        
        return lA;
    }
}