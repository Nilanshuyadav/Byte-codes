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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1, list1), l=dummy, r=dummy;
        int len = b-a+2;
        
        while(len-->0){
            r = r.next;
        }
        
        int ind=1;
        while(ind++<=a){
            l = l.next;
            r = r.next;
        }
        
        l.next = list2;
        
        while(l.next!=null){
            l = l.next;
        }
        
        l.next = r;
        
        return dummy.next;
    }
}