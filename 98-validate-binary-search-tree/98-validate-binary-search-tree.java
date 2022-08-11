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
    public boolean isValidBST(TreeNode root) {     
        // if(root.left != null && root.left.val >= root.val) return false;
        // if(root.right != null && root.right.val <= root.val) return false;
        // return isValidBST2(root.left,root,1) && isValidBST2(root.right,root,0);
        List<Integer> al = new ArrayList();
        function(root,al);
        
        for(int i = 1;i<al.size();i++)
            if(al.get(i) <= al.get(i-1)) return false;
        
        return true;
    }
    
    public void function(TreeNode root, List<Integer> al){
        if(root == null) return;
        
        function(root.left,al);
        al.add(root.val);
        function(root.right,al);
    }
    
//     public boolean isValidBST2(TreeNode root, TreeNode parent,int i){
//         if(root == null) return true;
//         if(root.left != null && (root.left.val >= root.val || (root.left.val <= parent.val && i==0))) return false;
//         if(root.right != null && (root.right.val <= root.val || (root.right.val >= parent.val && i == 1))) return false;
        
//         return isValidBST2(root.left,root,1) && isValidBST2(root.right,root,0);
//     }
}