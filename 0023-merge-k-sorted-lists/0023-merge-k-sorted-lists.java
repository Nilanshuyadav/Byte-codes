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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        
        if(n == 0){
            return null;
        }
        
        ListNode dummy = new ListNode();
        
        for(int ind=0; ind<n; ind++){
            if(lists[ind] != null){
                if(dummy.next == null){
                    dummy.next = lists[ind];
                }    
                else{
                    dummy = merge(dummy, dummy.next, lists[ind]);
                }
            }
        }
        
        return dummy.next;
    }
    
    public ListNode merge(ListNode dummy, ListNode l1, ListNode l2){
        ListNode curr1 = l1, curr2 = l2, curr = dummy;
        
        while(curr1 != null && curr2 != null){
            if(curr1.val < curr2.val){
                curr.next = curr1;
                curr = curr1;
                
                curr1 = curr1.next;
            }
            else{
                curr.next = curr2;
                curr = curr2;
                
                curr2 = curr2.next;
            }
        }
        
        if(curr1 != null){
            curr.next = curr1;
        }
        
        if(curr2 != null){
            curr.next = curr2;
        }
        
        return dummy;
    }
}