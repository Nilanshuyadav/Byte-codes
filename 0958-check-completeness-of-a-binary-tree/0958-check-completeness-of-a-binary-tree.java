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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        boolean lastLevel = false, endNode=false;
        
        q.add(root);
        int level=0, size;
        TreeNode temp;
        
        while(!q.isEmpty()){
            size = q.size();
            
            if(size < Math.pow(2, level))   lastLevel = true;
            
            while(size-->0){
                temp = q.remove();
                
                if(temp.left != null && (endNode || lastLevel))    return false;
                if(temp.left != null)   q.add(temp.left);
                else    endNode = true;
                
                if(temp.right != null && (endNode || lastLevel))    return false;
                if(temp.right != null)  q.add(temp.right);
                else    endNode = true;
            }
            
            endNode = false;
            level++;
        }
        
        return true;
    }
}