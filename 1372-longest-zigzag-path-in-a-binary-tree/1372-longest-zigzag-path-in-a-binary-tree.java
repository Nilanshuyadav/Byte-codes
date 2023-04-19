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
    int max;
    public int longestZigZag(TreeNode root) {
        max = Integer.MIN_VALUE;
        
        int left = solve(root.left, 'l') + 1;
        int right = solve(root.right, 'r') + 1;
        
        return Math.max(max, Math.max(left, right)) - 1;
    }
    
    public int solve(TreeNode node, Character left_right){
        if(node == null){
            return 0;
        }
        
        int left = solve(node.left, 'l') + 1;
        int right = solve(node.right, 'r') + 1;
        
        max = Math.max(max, Math.max(left, right));
        
        return left_right=='l' ? Math.max(1, right) : Math.max(1, left);
    }
}