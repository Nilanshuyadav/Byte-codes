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
    public boolean isValidBST(TreeNode root) {
        return function(root.left,Long.MIN_VALUE,root.val) && function(root.right,root.val,Long.MAX_VALUE);
    }
    
    public boolean function(TreeNode root, long low, long high){
        if(root == null) return true;
        
        if(root.val <= low || root.val >= high) return false;
        
        return function(root.left,low,root.val) && function(root.right,root.val,high);
    }
}