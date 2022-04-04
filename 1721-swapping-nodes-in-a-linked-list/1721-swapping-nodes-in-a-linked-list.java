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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left,right,h1 = head;
        
        int n = 0;
        
        while(h1 != null){
            n++;
            if(n == k){
                break;
            }    
            h1 = h1.next;
        }
        
        left = h1;
        
        ListNode h2 = head;
        
        while(h1.next!=null){
            h1 = h1.next;
            h2 = h2.next;
        }
        
        right = h2;
        
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        
        return head;
    }
}