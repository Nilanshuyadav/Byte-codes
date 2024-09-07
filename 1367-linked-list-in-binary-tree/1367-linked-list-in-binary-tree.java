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
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> al = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        TreeNode temp;
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            if(head.val == temp.val){
                al.add(temp);
            }
            
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        
        for(TreeNode rt : al){
            if(helper(rt, head)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean helper(TreeNode root, ListNode curr){        
        if(curr == null) return true;
        
        if(root==null || root.val != curr.val) return false;
        
        return helper(root.left, curr.next) || helper(root.right, curr.next);
    }
}