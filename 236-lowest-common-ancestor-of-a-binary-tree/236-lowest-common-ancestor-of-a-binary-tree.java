/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) return root;
        
        TreeNode rootleft = lowestCommonAncestor(root.left,p,q);
        TreeNode rootright = lowestCommonAncestor(root.right,p,q);
        
//         if(rootleft!=null && rootright!=null) return root;
        
//         if(rootleft == rootright) return root;
//         return rootleft==null?rootright:rootleft;
        
        if(rootleft == null) return rootright;
        if(rootright == null) return rootleft;
        return root;
        
    }
}