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
        max = 0;
        return Math.max(solve(root,-1), max)-1;
    }
    
    public int solve(TreeNode root, int left_right){
        int right=0, left=0;
        
        if(root.left != null)
            left = solve(root.left, 0);
        
        if(root.right != null)
            right = solve(root.right, 1);
        
        if(right>left && left_right==1){
            max = Math.max(max, 1+right);
            right=0;
        }
        else if(left>right && left_right==0){
            max = Math.max(max, 1+left);
            left=0;
        }
        
        return Math.max(left, right)+1;
    }
}