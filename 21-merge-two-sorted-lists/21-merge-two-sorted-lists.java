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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        
        ListNode curr = ans, ptr1 = list1, ptr2 = list2;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode temp = new ListNode(list1.val);
                ans.next = temp;
                list1 = list1.next;
                ans = ans.next;
            }
            
            else{
                ListNode temp = new ListNode(list2.val);
                ans.next = temp;
                list2 = list2.next;
                ans = ans.next;
            }
        }
        
        while(list1 != null){
            ListNode temp = new ListNode(list1.val);
            ans.next = temp;
            list1 = list1.next;
            ans = ans.next;
        }
        
        while(list2 != null){
            ListNode temp = new ListNode(list2.val);
            ans.next = temp;
            list2 = list2.next;
            ans = ans.next;
        }
        
        return curr.next;
    }
}