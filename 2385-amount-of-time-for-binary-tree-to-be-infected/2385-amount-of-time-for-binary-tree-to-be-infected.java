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
    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int ind=0; ind<100001; ind++)
            adj.add(new ArrayList<>());
        
        convert_to_graph(root, adj);
        
        int[] dist = new int[100001];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int temp = q.remove();
            
            for(int ind : adj.get(temp)){
                if(dist[temp]+1 < dist[ind]){
                    dist[ind] = dist[temp]+1;
                    q.add(ind);
                }
            }
        }
        
        int max = 0;
        
        for(int ind : dist){
            if(ind != Integer.MAX_VALUE)
                max = Math.max(max, ind);
        }
        
        return max;
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