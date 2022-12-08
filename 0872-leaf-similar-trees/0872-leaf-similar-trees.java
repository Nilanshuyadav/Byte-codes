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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> al_1 = new ArrayList<>(), al_2 = new ArrayList<>();
        
        get_leaf_root(root1, al_1);
        
        get_leaf_root(root2, al_2);
        
        int n1 = al_1.size(), n2 = al_2.size();
        
        if(n1 != n2)
            return false;
        
        for(int ind=0; ind<n1; ind++)
            if(al_1.get(ind) != al_2.get(ind))
                return false;
        
        return true;
    }
    
    public void get_leaf_root(TreeNode root, List<Integer> al){
        if(root.left==null && root.right==null){
            al.add(root.val);
            return;
        }
        
        if(root.left != null)
            get_leaf_root(root.left, al);
        
        if(root.right != null)
            get_leaf_root(root.right, al);
    }
}