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
    int sum, distance;
    public int countPairs(TreeNode root, int dis) {
        sum = 0;
        distance = dis;
        
        dfs(root, new HashMap<>());
        
        return sum;
    }
    
    public Map<Integer, Integer> dfs(TreeNode node, Map<Integer, Integer> map){
        if(node.left==null && node.right==null){
            map.put(1, 1);
            return map;
        }
        
        Map<Integer, Integer> l_map = new HashMap<>(), r_map = new HashMap<>();
        
        if(node.left != null)
            l_map = dfs(node.left, new HashMap<>());
        
        if(node.right != null)
            r_map = dfs(node.right, new HashMap<>());
        
        Map<Integer, Integer> map_res = new HashMap<>();
        
        if(l_map != null && r_map!=null){
            for(Map.Entry<Integer, Integer> entry1 : l_map.entrySet()){
                for(Map.Entry<Integer, Integer> entry2 : r_map.entrySet()){
                    if(entry1.getKey()+entry2.getKey() <= distance){
                        sum += (entry1.getValue()*entry2.getValue());
                    }
                }
            }

        }
        
        if(l_map != null)
            for(Map.Entry<Integer, Integer> entry : l_map.entrySet()){
                map_res.put(entry.getKey()+1, entry.getValue());
            }
        
        if(r_map != null)
            for(Map.Entry<Integer, Integer> entry : r_map.entrySet()){
                map_res.put(entry.getKey()+1, map_res.getOrDefault(entry.getKey()+1,0) + entry.getValue());
            }
        
        return map_res;
        
    }
}