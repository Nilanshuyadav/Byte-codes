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
    public int maxPathSum(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        int max = dfs(root, set);
        int temp_max = root.val;
        
        for(int ind : set)
            temp_max = Math.max(temp_max, ind);
        
        return max==0?temp_max:Math.max(temp_max, max);
    }
    
    public int dfs(TreeNode root, Set<Integer> set){
        if(root == null)
            return 0;
        
        int left = dfs(root.left, set);
        int right = dfs(root.right, set);
        
        set.add(left+right+root.val);
        set.add(root.val);
        
        return Math.max(0,Math.max(left, right)+root.val);
    }
}