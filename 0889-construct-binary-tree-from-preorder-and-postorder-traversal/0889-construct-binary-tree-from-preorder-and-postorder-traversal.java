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
    int pre_ind, post_ind;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        pre_ind = 0;
        post_ind = 0;
        
        return dfs(preorder, postorder);
    }
    
    public TreeNode dfs(int[] preorder, int[] postorder){
        TreeNode temp = new TreeNode(preorder[pre_ind]);
        
        if(preorder[pre_ind] == postorder[post_ind]){
            post_ind++;
            return temp;
        }
        
        int node = preorder[pre_ind];
        
        pre_ind++;
        temp.left = dfs(preorder, postorder);
        
        if(node == postorder[post_ind]){
            post_ind++;
            return temp;
        }
        
        pre_ind++;
        temp.right = dfs(preorder, postorder);
        
        post_ind++;
        return temp;
    }
}