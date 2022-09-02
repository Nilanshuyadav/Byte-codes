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
        if(head.next==null) return true;
        if(head.next.next==null) return head.val==head.next.val;
        ListNode slow = head, fast = head;
        
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast.next!=null && fast.next.next!=null);
        
        slow.next = dfs(null,slow.next);
        
        fast = slow.next;
        slow = head;
        
        while(fast!=null){
            if(slow.val!=fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    public ListNode dfs(ListNode pre,ListNode curr){
        if(curr == null) return pre;
        
        ListNode next = curr;
        curr = curr.next;
        
        next.next = pre;
        return dfs(next,curr);
    }
}