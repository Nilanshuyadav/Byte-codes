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
    int ind=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(0, preorder.length-1, preorder, inorder);
    }
    
    public TreeNode solve(int l, int r, int[] preorder, int[] inorder){
        
        if(l==r){
            return new TreeNode(preorder[ind]);
        }
        
        TreeNode node = new TreeNode(preorder[ind]);
        int index = findIndex(preorder[ind], inorder);
        
        if(l<=index-1){
            ind++;
            node.left = solve(l, index-1, preorder, inorder);    
        }
        
        if(index+1<=r){
            ind++;
            node.right = solve(index+1, r, preorder, inorder);    
        }
        
        
        return node;
    }
    
    public int findIndex(int target, int[] inorder){
        for(int ind=0; ind<inorder.length; ind++){
            if(inorder[ind] == target){
                return ind;
            }
        }
        
        return -1;
    }
}