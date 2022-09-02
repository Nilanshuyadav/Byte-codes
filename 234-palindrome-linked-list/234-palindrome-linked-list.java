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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        
        ListNode curr = head;
        while(curr!=null){
            al.add(curr.val);
            curr = curr.next;
        }
        
        int low = 0, high = al.size()-1;
        
        while(low<high){
            if(al.get(low)!=al.get(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}