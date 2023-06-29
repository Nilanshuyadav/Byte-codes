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
    int cnt, ans;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        ans = -1;
        
        inOrder(root);
        return ans;
    }
    
    public void inOrder(TreeNode root){
        if(root.left != null && ans == -1)   inOrder(root.left);
        cnt--;
        if(cnt == 0){
            ans = root.val;
            return;
        }
        if(root.right != null && ans == -1)  inOrder(root.right);
    }
}