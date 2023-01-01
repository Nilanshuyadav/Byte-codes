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
       
        ListNode dummy = new ListNode();
        
        solve(dummy, lists, n-1);
        
        return dummy.next;
    }
    
    public void solve(ListNode dummy, ListNode[] lists, int ind){
        if(ind == -1)
            return;
        
        if(ind==0){
            dummy.next = lists[ind];
            return;
        }
        
        solve(dummy, lists, ind-1);
        
        ListNode curr = dummy, currA = dummy.next, currB = lists[ind];
        
        while(currA!=null && currB!=null){
            if(currA.val<currB.val){
                curr.next = currA;
                currA = currA.next;
            }
            else{
                curr.next = currB;
                currB = currB.next;
            }
            
            curr = curr.next;
        }
        
        while(currA!=null){
            curr.next = currA;
            currA = currA.next;
            curr = curr.next;
        }
        
        while(currB!=null){
            curr.next = currB;
            currB = currB.next;
            curr = curr.next;
        }
    }
}