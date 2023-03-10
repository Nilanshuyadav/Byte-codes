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
    List<Integer> al;
    int size;
    public Solution(ListNode head) {
        al = new ArrayList<>();
        
        while(head!=null){
            al.add(head.val);
            head = head.next;
        }
        
        size = al.size();
    }
    
    public int getRandom() {
        int temp = (int)(Math.random()*size);
        return al.get(temp);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */