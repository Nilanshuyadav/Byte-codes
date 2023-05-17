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
    public int pairSum(ListNode head) {
        List<Integer> al = new ArrayList<>();
        ListNode curr = head;
        
        while(curr != null){
            al.add(curr.val);
            
            curr = curr.next;
        }
        
        int i=0, j=al.size()-1;
        int max = -1;
        
        while(i<j){
            max = Math.max(max, al.get(i++)+al.get(j--));
        }
        
        return max;
    }
}