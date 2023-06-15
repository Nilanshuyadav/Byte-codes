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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        
        inOrder(root, al);
        
        int min = (int)1e8, n=al.size();
        
        for(int i=1; i<n; i++){
            min = Math.min(min, Math.abs(al.get(i)-al.get(i-1)));
        }
        
        return min;
    }
    
    public void inOrder(TreeNode root, List<Integer> al){
        if(root == null){
            return;
        }
        
        inOrder(root.left, al);
        al.add(root.val);
        inOrder(root.right, al);
    }
}