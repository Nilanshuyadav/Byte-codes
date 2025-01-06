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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 1));
        long l=0, r=0, size;
        long col;
        long max=0;
        Pair curr;
        TreeNode temp;
            
        while(!q.isEmpty()){
            size = q.size();
            l = Long.MAX_VALUE;
            r = Long.MIN_VALUE;
            
            while(size-->0){
                curr = q.remove();
                
                temp = curr.node;
                col = curr.col;
                
                l = Math.min(l, col);
                r = Math.max(r, col);
                                
                max = Math.max(max, r-l);
                
                if(temp.left!=null) q.add(new Pair(temp.left, (2*col)-1));
                if(temp.right!=null) q.add(new Pair(temp.right, (2*col)));
            }
        }
        
        return (int)max+1;
    }
}

class Pair{
    TreeNode node;
    long col;
    
    public Pair(TreeNode node, long col){
        this.node = node;
        this.col = col;
    }
}