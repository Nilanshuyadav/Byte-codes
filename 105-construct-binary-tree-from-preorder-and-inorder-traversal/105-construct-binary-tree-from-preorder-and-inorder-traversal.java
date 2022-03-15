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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        Map<Integer,Integer> map = new HashMap();
        int n = preorder.length;
        
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        
        return helper(preorder,0,n-1,inorder,0,n-1,map);
        
    }
    
    private TreeNode helper(int[] preorder,int startpreorder,int endpreorder,int[] inorder,int startinorder,int endinorder, Map<Integer,Integer> map){
        
        if(startpreorder>endpreorder || startinorder>endinorder) return null;
        
        TreeNode root = new TreeNode(preorder[startpreorder]);
        int inroot = map.get(root.val);
        int numsleft = inroot - startinorder;
        
            root.left = helper(preorder,startpreorder+1,startpreorder+numsleft,inorder,startinorder,inroot-1,map);
        root.right = helper(preorder,startpreorder+numsleft+1,endpreorder,inorder,inroot+1,endinorder,map);
        
        return root;
        
    }
}