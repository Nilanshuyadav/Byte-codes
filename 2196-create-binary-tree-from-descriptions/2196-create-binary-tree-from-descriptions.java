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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i[] : descriptions){
            if(!map.containsKey(i[0])){
                map.put(i[0], new TreeNode(i[0]));
            }
            
            if(!map.containsKey(i[1])){
                map.put(i[1], new TreeNode(i[1]));
            }
            
            set.add(i[1]);
            
            if(i[2]==0){
                map.get(i[0]).right = map.get(i[1]);
            }
            else{
                map.get(i[0]).left = map.get(i[1]);
            }
        }
        
        for(Map.Entry<Integer, TreeNode> entry : map.entrySet()){
            if(!set.contains(entry.getKey())){
                return entry.getValue();
            }
        }
        
        return new TreeNode(0);
    }
}