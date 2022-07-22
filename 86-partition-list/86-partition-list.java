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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0,head), dummy2 = new ListNode(0);
        ListNode curr = head, temp1 = dummy1, temp2 = dummy2;
        
        while(curr != null){
            if(curr.val < x){
                temp1.next = curr.next;
                temp2.next = curr;
                temp2 = temp2.next;
                curr = curr.next;
            }
            
            else{
                curr = curr.next;
                temp1 = temp1.next;
            }
        }
        
        temp2.next = dummy1.next;
        
        return dummy2.next;
    }
}