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
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }
    
    public int helper(TreeNode node, int pre){
        if(node == null) return 0;
        
        int r=0, l=0;
        
        r = helper(node.right, pre);
        
        node.val += r;
        if(node.right==null){
            node.val += pre;
        }
        
        l = helper(node.left, node.val);
        
        return node.left==null? node.val : l;
    }
}