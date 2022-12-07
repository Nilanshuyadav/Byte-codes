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
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<100001; ind++)
            adj.add(new ArrayList<>());
        
        convert_to_graph(root, adj);
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[100001];
        
        q.add(target.val);
        vis[target.val] = true;
        
        while(!q.isEmpty()){
            if(k == 0)
                break;
            
            int size = q.size();
            
            while(size-->0){
                int temp = q.remove();
                
                for(int ind : adj.get(temp))
                    if(!vis[ind]){
                        vis[ind] = true;
                        q.add(ind);
                    }
            }
            
            k--;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty())
            ans.add(q.remove());
        
        return ans;
    }
    
    public void convert_to_graph(TreeNode root, List<List<Integer>> adj){
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            
            if(temp.left != null){
                adj.get(temp.val).add(temp.left.val);
                adj.get(temp.left.val).add(temp.val);
                q.add(temp.left);
            }
            
            if(temp.right != null){
                adj.get(temp.val).add(temp.right.val);
                adj.get(temp.right.val).add(temp.val);
                q.add(temp.right);
            }
        }
    }
}