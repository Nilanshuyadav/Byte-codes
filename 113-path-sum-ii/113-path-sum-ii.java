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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     
        List<Integer> list = new ArrayList<Integer>();
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        helper(root,list,ans,targetSum);
        
        return ans;
    }
    
    private void helper(TreeNode root,List<Integer> list,List<List<Integer>> ans ,int targetsum){
        if(root == null) return;
        
        List<Integer> temp = new ArrayList<Integer>(list);
        temp.add(root.val);
        
        if(targetsum - root.val == 0 && root.left == null && root.right == null){
            ans.add(temp);
            return;
        }
        
        
        helper(root.left,temp,ans,targetsum-root.val);
        helper(root.right,temp,ans,targetsum-root.val);
    }
}