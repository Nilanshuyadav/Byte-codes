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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode slow = head, fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        
        return merge(sortList(head), sortList(temp));
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(), curr = dummy;
        ListNode c1=l1, c2 = l2;
        
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                curr.next = c1;
                curr = c1;
                c1 = c1.next;
            }
            else{
                curr.next = c2;
                curr = c2;
                c2 = c2.next;
            }
        }
        
        if(c1!=null){
            curr.next = c1;
        }
        
        if(c2!=null){
            curr.next = c2;
        }
        
        return dummy.next;
    }
}