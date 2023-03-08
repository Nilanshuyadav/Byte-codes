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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int size, pq_size=0;
        TreeNode temp;
        long sum;
        
        while(!q.isEmpty()){
            size = q.size();
            sum = 0;
            
            while(size-->0){
                temp = q.remove();
                
                sum += temp.val;
                
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            
            if(pq_size==k){
                if(pq.peek() < sum){
                    pq.remove();
                    pq.add(sum);
                }
            }
            else{
                pq.add(sum);
                pq_size++;
            }
        }
        
        return pq_size==k ? pq.remove() : -1;
    }
}