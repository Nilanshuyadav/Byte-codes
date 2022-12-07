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
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        inorder(root, low, high);
        
        return ans;
    }
    
    public void inorder(TreeNode root, int low, int high){
        if(root == null)
            return; 
        
        inorder(root.left, low, high);
        
        if(low<=root.val && root.val<=high)
            ans += root.val;
        
        inorder(root.right, low, high);
    }
}