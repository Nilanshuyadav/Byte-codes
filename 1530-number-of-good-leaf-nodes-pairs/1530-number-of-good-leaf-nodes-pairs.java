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
    public int countPairs(TreeNode root, int dis) {
        
        return dfs(root, new HashMap<>(), dis);
    }
    
    public int dfs(TreeNode node, Map<Integer, Integer> map, int dis){
        if(node.left==null && node.right==null){
            map.put(1, 1);
            return 0;
        }
        
        int sum = 0;
        Map<Integer, Integer> l_map = new HashMap<>(), r_map = new HashMap<>();
        
        if(node.left != null)
            sum += dfs(node.left, l_map, dis);
        
        if(node.right != null)
            sum += dfs(node.right, r_map, dis);
    
        for(Map.Entry<Integer, Integer> entry1 : l_map.entrySet()){
            for(Map.Entry<Integer, Integer> entry2 : r_map.entrySet()){
                if(entry1.getKey()+entry2.getKey() <= dis){
                    sum += (entry1.getValue()*entry2.getValue());
                }
            }
        }


        for(Map.Entry<Integer, Integer> entry : l_map.entrySet()){
            map.put(entry.getKey()+1, entry.getValue());
        }

        for(Map.Entry<Integer, Integer> entry : r_map.entrySet()){
            map.put(entry.getKey()+1, map.getOrDefault(entry.getKey()+1,0) + entry.getValue());
        }
        
        return sum;
        
    }
}