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
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode end_node = end_node(root.left);
        
        if(end_node != null){

            end_node.right = root.right;
            root.right = root.left;

            root.left = null;
        }
        
        flatten(root.right);
    }
    
    
    public TreeNode end_node(TreeNode node){
        if(node == null) return null;
        
        if(node.right != null) return end_node(node.right);
        else if(node.left != null) return end_node(node.left);
        else return node;
    }
}