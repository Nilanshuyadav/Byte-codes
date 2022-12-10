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
    public int maxProduct(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        
        int total = dfs(root, set);
        
        long max = 0, curr = 0;
        
        for(long ind : set){
            long one = ind;
            long sec = total-ind;
            
            curr = (one*sec);
            max = Math.max(max, curr);
        }
        
        return (int)(max%1000000007);
    }
    
    public int dfs(TreeNode root, Set<Integer> set){
        if(root == null)
            return 0;
        
        int left = dfs(root.left, set);
        int right = dfs(root.right, set);
        
        set.add(left+right+root.val);
        
        return left+right+root.val;
    }
}