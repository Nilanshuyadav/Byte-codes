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
    public int maxLevelSum(TreeNode root) {
        long max=-(int)1e8;
        int ans=0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int size;
        int level=0;
        long sum;
        
        TreeNode temp;
        
        while(!q.isEmpty()){
            size = q.size();
            level++;
            
            sum = 0;
            
            while(size-->0){
                temp = q.remove();
                
                sum += temp.val;
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            
            if(max < sum){
                max = sum;
                ans = level;
            }
        }
        
        return ans;
    }
}