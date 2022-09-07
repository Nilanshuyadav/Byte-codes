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
    public String tree2str(TreeNode root) {
        StringBuilder st = new StringBuilder("");
        dfs(st,root);
        return st.toString();
    }
    
    public void dfs(StringBuilder st, TreeNode root){
        if(root.left==null && root.right==null){
            st.append(root.val);
            return;
        }
        
        st.append(root.val);    
        if(root.left != null) {st.append('('); dfs(st,root.left); st.append(')');}
        if(root.left==null && root.right!=null){st.append("()");}
        if(root.right!=null){st.append('('); dfs(st,root.right);st.append(')');}
    }
}