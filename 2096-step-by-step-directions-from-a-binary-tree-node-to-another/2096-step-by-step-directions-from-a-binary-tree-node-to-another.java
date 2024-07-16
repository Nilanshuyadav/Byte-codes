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
    TreeNode s, e;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        mapParent(root, map, startValue, destValue);
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.sb.length()-b.sb.length());
        
        q.add(new Pair(s, "", 0));
        Pair temp;
        
        while(!q.isEmpty()){
            temp = q.remove();
            if(temp.node.val == destValue){
                return temp.sb;
            }
            
            if(temp.sb.equals("")){
                if(temp.node.right!=null) q.add(new Pair(temp.node.right, temp.sb+"R", 0));
                if(temp.node.left!=null) q.add(new Pair(temp.node.left, temp.sb+"L", 0));
                if(map.containsKey(temp.node)) q.add(new Pair(map.get(temp.node), temp.sb+"U", map.get(temp.node).left==temp.node ? 1 : 2));
            }
            else if(temp.sb.charAt(temp.sb.length()-1) == 'U'){
                if(temp.fl==1){
                    if(temp.node.right!=null) q.add(new Pair(temp.node.right, temp.sb+"R", 0));
                    if(map.containsKey(temp.node)) q.add(new Pair(map.get(temp.node), temp.sb+"U", map.get(temp.node).left==temp.node ? 1 : 2));
                }
                else{
                    if(temp.node.left!=null) q.add(new Pair(temp.node.left, temp.sb+"L", 0));
                    if(map.containsKey(temp.node)) q.add(new Pair(map.get(temp.node), temp.sb+"U", map.get(temp.node).left==temp.node ? 1 : 2));
                }
            }
            else{
                if(temp.node.right!=null) q.add(new Pair(temp.node.right, temp.sb+"R", 0));
                if(temp.node.left!=null) q.add(new Pair(temp.node.left, temp.sb+"L", 0));
            }
            
        }
        
        return "";
    }
    
    public void mapParent(TreeNode root, Map<TreeNode, TreeNode> map, int st, int en){
        TreeNode temp;
        
        if(root.val == st){
            s = root;
        }
        
        if(root.val == en){
            e = root;
        }
        
        if(root.left!=null){
            map.put(root.left, root);
            mapParent(root.left, map, st, en);
        }
        
        if(root.right!=null){
            map.put(root.right, root);
            mapParent(root.right, map, st, en);
        }
    }
}

class Pair{
    TreeNode node;
    String sb;
    int fl;
    
    public Pair(TreeNode node, String sb, int flag){
        this.node = node;
        this.sb = sb;
        this.fl = flag;
    }
}