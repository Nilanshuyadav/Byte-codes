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
    int ans;
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        boolean[] dp = new boolean[10];
        dfs(root,dp);
        return ans;
    }
    
    public void dfs(TreeNode root,boolean[] dp){
        if(root.left==null && root.right==null){
            if(dp[root.val]) dp[root.val] = false;
            else dp[root.val] = true;
            
            int t=0;
            for(int i=1;i<10;i++)
                if(dp[i]) t++;
            
            if(t<2) ans++;
            
            if(dp[root.val]) dp[root.val] = false;
            else dp[root.val] = true;
            return;
        }
        
        if(dp[root.val]) dp[root.val] = false;
        else dp[root.val] = true;
        
        if(root.left != null) dfs(root.left,dp);
        if(root.right != null) dfs(root.right,dp);
        
        if(dp[root.val]) dp[root.val] = false;
        else dp[root.val] = true;
    }
}