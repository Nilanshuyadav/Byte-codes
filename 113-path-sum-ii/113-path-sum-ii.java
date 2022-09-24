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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        
        if(root == null) return ans;
        dfs(root,new ArrayList<>(), targetSum);
        
        return ans;
    }
    
    public void dfs(TreeNode root, List<Integer> al, int t){
        if(root.val == t && root.right==null && root.left==null){
            al.add(root.val);
            ans.add(new ArrayList<>(al));
            al.remove(al.size()-1);
            return;
        }
        
        al.add(root.val);
        if(root.left != null) dfs(root.left, al,t-root.val);
        if(root.right != null) dfs(root.right,al,t-root.val);
        al.remove(al.size()-1);
    }
}