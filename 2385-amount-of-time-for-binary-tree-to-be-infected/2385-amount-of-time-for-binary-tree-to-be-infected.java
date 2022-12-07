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
    TreeNode start_node;
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        
        get_parent(root, null, parent, start);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(start_node);
        
        Set<Integer> set = new HashSet<>();
        set.add(start);
        
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                TreeNode temp =  q.remove();
                
                if(temp.left!=null && !set.contains(temp.left.val)){
                    set.add(temp.left.val);
                    q.add(temp.left);
                }
                
                if(temp.right!=null && !set.contains(temp.right.val)){
                    set.add(temp.right.val);
                    q.add(temp.right);
                }
                
                if(temp!=root && !set.contains(parent.get(temp).val)){
                    set.add(parent.get(temp).val);
                    q.add(parent.get(temp));
                }
            }
            
            ans++;
        }
        
        return ans-1;
    }
    
    public void get_parent(TreeNode child, TreeNode par, Map<TreeNode, TreeNode> parent, int start){
        if(child != null){
            if(child.val == start)
                start_node = child;
            
            parent.put(child, par);
            get_parent(child.left, child, parent, start);
            get_parent(child.right, child, parent, start);
        }
    }
}