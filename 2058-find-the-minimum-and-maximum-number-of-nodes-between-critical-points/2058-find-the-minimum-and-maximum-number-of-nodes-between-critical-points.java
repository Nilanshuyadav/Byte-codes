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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next, pre = head;
        int firstPos=-1, prePos=-1, currPos=1, min=(int)1e8, max=-1;
        
        while(curr.next!=null){
            if((pre.val<curr.val && curr.val>curr.next.val) || (pre.val>curr.val && curr.val<curr.next.val)){
                if(firstPos==-1){
                    firstPos = currPos;
                }
                else{
                    min = Math.min(min, currPos-prePos);
                    max = Math.max(max, currPos-firstPos);
                }
                
                prePos = currPos;
            }
            
            curr = curr.next;
            pre = pre.next;
            currPos++;
        }
        
        if(min==(int)1e8){
            min = -1;
        }
        
        return new int[]{min, max};
    }
}