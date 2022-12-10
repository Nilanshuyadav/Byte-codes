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
        
        int half = total/2;
        
        while(half>=0){
            if(set.contains(half) || set.contains(total-half)){
                long one = half;
                long sec = total-half;
                
                return (int)((one*sec)%1000000007);
            }
            
            half--;
        }
        
        return -1;
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