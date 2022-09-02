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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        
        ListNode odd_dummy = new ListNode(),even_dummy = new ListNode(),odd_curr = odd_dummy, even_curr = even_dummy, temp = head;
        
        boolean bool = false;
        while(temp!=null){
            if(bool){
                even_curr.next = temp;
                even_curr = temp;
                bool = false;
            }
            else{
                odd_curr.next = temp;
                odd_curr = temp;
                bool = true;
            }
            temp = temp.next;
        }
        
        odd_curr.next = even_dummy.next;
        even_curr.next = null;
        
        return odd_dummy.next;
    }
}