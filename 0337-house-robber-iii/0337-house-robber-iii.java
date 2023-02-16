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
    Map<String, Integer> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        
        return solve(root, true);
    }
    
    public int solve(TreeNode root, boolean picked){
        if(root == null)
            return 0;
        
        if(dp.containsKey(root+""+picked))
            return dp.get(root+""+picked);
        
        int pick = 0, not_pick = 0;
        
        if(picked){
            pick += root.val;
            pick += solve(root.left, false);
            pick += solve(root.right, false);
        }
        
        not_pick += solve(root.left, true);
        not_pick += solve(root.right, true);
        
        int max = Math.max(pick, not_pick);
        
        dp.put(root+""+picked, max);
        return max;
    }
}