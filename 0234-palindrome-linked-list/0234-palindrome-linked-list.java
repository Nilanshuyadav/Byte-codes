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
        List<Integer> al = new ArrayList<>();
        
        ListNode curr = head;
        
        while(curr!=null){
            al.add(curr.val);
            curr = curr.next;
        }
        
        int l=0, h=al.size()-1;
        
        while(l<h){
            if(al.get(l)!=al.get(h)){
                return false;
            }
            l++;
            h--;
        }
        
        return true;
    }
}