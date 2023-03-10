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
    int size;
    ListNode curr, h;
    
    public Solution(ListNode head) {
        curr = head;
        h=head;
        
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
    }
    
    public int getRandom() {
        int temp = (int)(Math.random()*size);
        
        curr=h;
        while(temp-->0){
            curr = curr.next;
        }
        
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */