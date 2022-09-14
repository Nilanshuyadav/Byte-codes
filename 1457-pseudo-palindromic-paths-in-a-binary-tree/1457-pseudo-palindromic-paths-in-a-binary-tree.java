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
        int[] dp = new int[10];
        dfs(root,dp);
        return ans;
    }
    
    public void dfs(TreeNode root,int[] dp){
        if(root.left==null && root.right==null){
            if(dp[root.val]!=0) dp[root.val]--;
            else dp[root.val]++;
            
            int sum = 0;
            for(int i=0;i<10;i++)
                sum += dp[i];
            
            if(sum<2) ans++;
            
            if(dp[root.val]==0) dp[root.val]++;
            else dp[root.val]--;
            return;
        }
        
        if(dp[root.val]!=0) dp[root.val]--;
        else dp[root.val]++;
        
        if(root.left != null) dfs(root.left,dp);
        if(root.right != null) dfs(root.right,dp);
        
        if(dp[root.val]==0) dp[root.val]++;
        else dp[root.val]--;
    }
}