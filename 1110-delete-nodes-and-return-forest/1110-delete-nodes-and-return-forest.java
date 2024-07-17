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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        
        for(int i : to_delete){
            set.add(i);
        }
        
        List<TreeNode> al = new ArrayList<>();
        helper(root, al, set, true);
        return al;
    }
    
    public void helper(TreeNode root, List<TreeNode> al, Set<Integer> set, boolean fl){
        if(fl && !set.contains(root.val)){
            al.add(root);
        }
        
        if(root.left != null){
            helper(root.left, al, set, set.contains(root.val)? true : false);
            
            if(set.contains(root.left.val)){
                root.left = null;
            }
        }
        
        if(root.right != null){
            helper(root.right, al, set, set.contains(root.val)? true : false);
            
            if(set.contains(root.right.val)){
                root.right = null;
            }
        }
        
    }
}