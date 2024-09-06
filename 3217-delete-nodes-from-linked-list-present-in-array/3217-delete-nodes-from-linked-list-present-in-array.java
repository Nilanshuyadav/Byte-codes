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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums) set.add(i);
        
        ListNode dummy = new ListNode(),pre = dummy, curr = head;
        
        while(curr!=null){
            if(!set.contains(curr.val)){
                pre.next = curr;
                pre = curr;
            }
            
            curr = curr.next;
        }
        
        pre.next = null;
        
        return dummy.next;
    }
}