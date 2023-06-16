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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> al = new ArrayList<>();
        
        helper(root, al);
        return al.get(k-1);
    }
    
    public void helper(TreeNode root, List<Integer> al){
        if(root == null){
            return;
        }
        
        helper(root.left, al);
        
        al.add(root.val);
        
        helper(root.right, al);
    }
}