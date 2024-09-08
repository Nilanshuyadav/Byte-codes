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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[] = new ListNode[k];
        
        ListNode dummy = new ListNode (0, head), curr = dummy;
        int size = findLen(head);
        int perShare = size/k;
        int remainder = size%k;
        
        int temp ;
        
        for(int i=0; i<k; i++){
            temp = perShare;
            
            if(dummy.next == null) break;
            
            while(temp-->0){
                curr = curr.next;
            }
            
            if(remainder-->0){
                curr = curr.next;
            }
            
            ans[i] = dummy.next;
            dummy.next = curr.next;
            curr.next= null;
            
            curr = dummy;
        }
        
        return ans;
    }
    
    public int findLen(ListNode temp){
        ListNode curr = temp;
        
        int len = 0;
        
        while(curr!=null){
            curr = curr.next;
            len++;
        }

        return len;
    }
}