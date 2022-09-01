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
    int cnt;
    public int goodNodes(TreeNode root) {
        cnt = 0;
        dfs(root,root.val);
        return cnt;
    }
    
    public void dfs(TreeNode root, int max){
        if(root.val>=max){
            cnt++;
            max = Math.max(max,root.val);
        }
        
        if(root.left!=null) dfs(root.left,max);
        if(root.right!=null) dfs(root.right,max);
    }
}