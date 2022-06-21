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
        ListNode curr = head, slow = head,bslow = head,fast = head;
        int flg = 0;
        
        if(head.next == null) return true;
        
        while(fast != null && fast.next != null){
            if(flg == 1) bslow = bslow.next;
            slow = slow.next;
            fast = fast.next.next;
            flg = 1;
        }
        
        if(fast == null){ 
            
            slow = reverse(slow);
            
            while(slow != null){
                if(curr.val != slow.val) return false;
                slow = slow.next;
                curr = curr.next;
            }
            
        }    
        else{
             slow.next = reverse(slow.next);
            
            slow = slow.next;
            
            while(slow != null){
                if(curr.val != slow.val) return false;
                slow = slow.next;
                curr = curr.next;
            }
        }    
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = null,curr = head, nex = curr.next;
        
        while(nex != null){
            curr.next = pre;
            pre = curr;
            curr = nex;
            nex = nex.next;
        }
        
        curr.next = pre;
        
        return curr;
    }
}