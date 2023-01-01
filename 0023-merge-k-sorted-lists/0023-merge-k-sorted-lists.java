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
        ListNode dummy = new ListNode(), curr = dummy;
        
        int n = lists.length;
        
        if(n <= 1)
            return n==0?null:lists[0];
        
        ListNode currA=lists[0], currB;
        
        for(int ind=1; ind<n; ind++){
            currB = lists[ind];
            
            while(currA!=null && currB!=null){
                if(currA.val < currB.val){
                    curr.next = currA;
                    curr = currA;
                    currA = currA.next;
                }
                else{
                    curr.next = currB;
                    curr = currB;
                    currB = currB.next;
                }
            }
            
            while(currA!=null){
                curr.next = currA;
                curr = currA;
                currA = currA.next;
            }
            
            while(currB!=null){
                curr.next = currB;
                curr = currB;
                currB = currB.next;
            }
            
            curr = dummy;
            currA = dummy.next;
        }
        
        return dummy.next;
    }
}