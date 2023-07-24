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
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        
        for(int ind=0; ind<n; ind++) map.put(inorder[ind], ind);
        
        return solve(0, n-1, preorder, inorder, map);
    }
    
    public TreeNode solve(int l, int r, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        
        if(l==r){
            return new TreeNode(preorder[ind]);
        }
        
        TreeNode node = new TreeNode(preorder[ind]);
        int index = map.get(preorder[ind]);
        
        if(l<=index-1){
            ind++;
            node.left = solve(l, index-1, preorder, inorder, map);    
        }
        
        if(index+1<=r){
            ind++;
            node.right = solve(index+1, r, preorder, inorder, map);    
        }
        
        
        return node;
    }
}