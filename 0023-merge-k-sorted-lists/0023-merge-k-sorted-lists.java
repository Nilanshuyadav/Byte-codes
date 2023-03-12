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
        
        if(n==0)    return null;
        
        ListNode dummy = new ListNode();
        
        return solve(0, lists, n);
    }
    
    public ListNode solve(int ind, ListNode[] lists, int n){
        if(ind == n-1){
            return lists[ind];
        }
        
        ListNode dummy = new ListNode(), curr1 = lists[ind], curr2 = solve(ind+1, lists, n), curr=dummy;
        
        while(curr1!=null && curr2!=null){
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
        else{
            curr.next = curr2;
        }
        
        return dummy.next;
    }
}