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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode curr = head;
        
        List<Integer> al = new ArrayList<>();
        
        while(curr != null){
            al.add(curr.val);
            curr = curr.next;
        }
        
        return treeConverter(al, 0, al.size());
    }
    
    public TreeNode treeConverter(List<Integer> al, int start, int end){
        if(end <= start){
            return null;
        }
        
        int mid = start + (end-start)/2;
        
        TreeNode root = new TreeNode(al.get(mid));
        
        root.left = treeConverter(al, start, mid);
        root.right = treeConverter(al, mid+1, end);
        
        return root;
    }
}