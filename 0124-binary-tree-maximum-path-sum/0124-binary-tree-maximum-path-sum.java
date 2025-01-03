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
    int ans;
    public int maxPathSum(TreeNode root) {
        ans = -(int)1e8;
        helper(root);
        return ans;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        ans = Math.max(ans, left+right+root.val);
        ans = Math.max(ans, root.val);
        ans = Math.max(ans, Math.max(left, right) + root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}