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
    int temp_max;
    public int maxPathSum(TreeNode root) {
        temp_max = root.val;
        int max = dfs(root);
        
        return temp_max;
    }
    
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        temp_max = Math.max(temp_max,left+right+root.val);
        
        return Math.max(0,Math.max(left, right)+root.val);
    }
}