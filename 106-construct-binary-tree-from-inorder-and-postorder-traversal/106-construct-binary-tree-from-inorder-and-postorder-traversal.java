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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
        int n = inorder.length;
        HashMap<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        
        return buildtree(inorder,0,n-1,postorder,0,n-1,map);
        
    }
    
    private TreeNode buildtree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend,Map<Integer,Integer> map){
        
        if(instart>inend || poststart>postend) return null;
        
        TreeNode root = new TreeNode(postorder[postend]);
        
        int inroot = map.get(postorder[postend]);
        int numsleft = inroot - instart;
        
        root.right = buildtree(inorder,inroot+1,inend,postorder,poststart+numsleft,postend-1,map);
        root.left = buildtree(inorder,instart,inroot-1,postorder,poststart,poststart+numsleft-1,map);
        
        return root;
        
    }
}


/*
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}*/