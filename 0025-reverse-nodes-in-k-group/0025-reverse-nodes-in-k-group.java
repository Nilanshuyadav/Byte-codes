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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr=dummy, i=head, next;
        int temp_k;
        
        while(i!=null){
            temp_k = k;
            
            while(i!=null && temp_k-->1){                
                i = i.next;
            }
            
            if(i==null) return dummy.next;
            
            next = i.next;
            i.next = null;
            
            curr.next = reverse(curr.next);
            
            while(curr.next!=null){
                curr = curr.next;
            }
            
            curr.next = next;
            i = curr.next;
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode node){
        ListNode pre = null, curr = node, next = curr.next;
        
        while(next!=null){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = pre;
        
        return curr;
    }
}