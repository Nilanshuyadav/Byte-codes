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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        Boolean lefttoright = true;
        
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            LinkedList<Integer> templist = new LinkedList<>();
            for(int i=0;i<n;i++){
                TreeNode temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                
                if(lefttoright) templist.add(temp.val);
                else templist.addFirst(temp.val);
            }
            ans.add(templist);
            lefttoright = !lefttoright;
            
        }
        
        return ans;
    }
}