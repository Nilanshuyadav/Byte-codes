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
    public TreeNode pruneTree(TreeNode root) {
        if(!dfs(root))return null;
        
        return root;
    }
    
    public boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }
        
        boolean temp1 = dfs(root.left);
        boolean temp2 = dfs(root.right);
        
        if(!temp1)
            root.left = null;
        if(!temp2)
            root.right = null;
        
        boolean b;
        if(root.val==1) b = true;
        else b = false;
        
        return temp1||temp2||b;
    }
}