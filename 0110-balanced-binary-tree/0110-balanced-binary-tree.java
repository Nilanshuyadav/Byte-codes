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
    public boolean isBalanced(TreeNode root) {
        int temp = solve(root);
        return temp<0?false:true;
    }
    
    public int solve(TreeNode node){
        if(node == null)
            return 0;
        
        int left = solve(node.left);
        int right = solve(node.right);
        
        if(left<0 || right<0)
            return -1;
        
        if(Math.abs(left-right)<=1)
            return Math.max(left, right)+1;
        return -1;
    }
}