/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        get_parent(root, null, map);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        q.add(target);
        set.add(target.val);
        
        while(!q.isEmpty()){
            if(k == 0)
                break;
            
            int size = q.size();
            
            while(size-->0){
                TreeNode temp = q.remove();
                
                if(temp.left != null && !set.contains(temp.left.val)){
                    set.add(temp.left.val);
                    q.add(temp.left);
                }
                
                if(temp.right != null && !set.contains(temp.right.val)){
                    set.add(temp.right.val);
                    q.add(temp.right);
                }
                
                if(temp!=root && !set.contains(map.get(temp).val)){
                    set.add(map.get(temp).val);
                    q.add(map.get(temp));
                }
            }
            
            k--;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty())
            ans.add(q.remove().val);
        
        return ans;
    }
    
    public void get_parent(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> map){
        if(child != null){
            map.put(child, parent);
            get_parent(child.left, child, map);
            get_parent(child.right, child, map);
        }
    }
}