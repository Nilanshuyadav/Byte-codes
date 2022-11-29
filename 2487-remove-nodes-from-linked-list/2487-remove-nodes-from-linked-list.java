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
    public ListNode removeNodes(ListNode head) {
        return dfs(head);
    }
    
    public ListNode dfs(ListNode root){
        if(root.next == null) return root;
        
        ListNode temp = dfs(root.next);
        
        if(root.val < temp.val)
            return temp;
        
        root.next = temp;
        return root;
    }
}