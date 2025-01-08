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
        
        int max = 1;
        q.add(new Pair(root,1));
        
        Pair temp;
        int size, ind, first;
        TreeNode node;
        
        while(!q.isEmpty()){
            size = q.size();
            
            first = -1;
            while(size-->0){
                temp = q.remove();
                
                node = temp.node;
                ind = temp.ind;

                if(first == -1){
                    first = ind;
                }
                else{
                    max = Math.max(max, ind-first+1);
                }

                if(node.left != null) q.add(new Pair(node.left, 2*ind));
                if(node.right != null) q.add(new Pair(node.right, 2*ind + 1));
            
            }
            
            // if(first == -1) break;
        }
        
        return max;
    }
}

class Pair{
    TreeNode node;
    int ind;
    
    public Pair(TreeNode node, int ind){
        this.node = node;
        this.ind = ind;
    }
}