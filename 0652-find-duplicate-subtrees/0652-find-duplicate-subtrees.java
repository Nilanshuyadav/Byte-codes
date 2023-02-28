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
    Map<String, TreeNode> map;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<String> set = new HashSet<>();
        map = new HashMap<>();
        
        solve(root, set);
        
        List<TreeNode> ans = new ArrayList<>();
        
        map.forEach((k,v) -> ans.add(v));
        
        return ans;    
    }
    
    public String solve(TreeNode node, Set<String> set){
        
        String st = ""+node.val;
        
        if(node.left==null){
            st += "ln";    
        }
        else{
            st += "l" + solve(node.left, set);
        }
        
        if(node.right==null){
            st += "rn";
        }
        else{
            st += "r" + solve(node.right, set);
        }
        
        if(!set.add(st)){
            map.put(st, node);
        }
        
        return st;
    }
}