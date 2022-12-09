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
    int max;
    public int maxAncestorDiff(TreeNode root) {
        max = 0;
        findDiff(root, new ArrayList<>());
    
        return max;
    }
    
    public void findDiff(TreeNode root, List<Integer> al){
        if(root.left==null && root.right==null){
            for(int inx : al)
                max = Math.max(max, Math.abs(inx-root.val));
            
            return;
        }
        
        al.add(root.val);
        
        if(root.left!=null)
            findDiff(root.left, al);
        if(root.right!=null)
            findDiff(root.right, al);
        
        al.remove(al.size()-1);
        
        for(int inx : al)
            max = Math.max(max, Math.abs(inx-root.val));
    }
}