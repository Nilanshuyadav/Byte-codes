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
        
        addParent(root, map);
        
        TreeNode tar = findTar(root, target);
        
        List<Integer> al = new ArrayList<>();
        
        solve(tar, map, al, k, new TreeNode(-1));
        
        return al;
    }
    
    public void solve(TreeNode tar, Map<TreeNode, TreeNode> map, List<Integer> al, int k, TreeNode pre){
        if(k==0){
            al.add(tar.val);
            return;
        }
        
        if(tar.left!=pre && tar.left!=null) solve(tar.left, map, al, k-1, tar);
        if(tar.right!=pre && tar.right!=null) solve(tar.right, map, al, k-1, tar);
        if(map.containsKey(tar) && map.get(tar)!=pre) solve(map.get(tar), map, al, k-1, tar);
    }
    
    public TreeNode findTar(TreeNode root, TreeNode target){
        if(root==null || root==target){
            return root;
        }
        
        TreeNode left = findTar(root.left, target),
            right = findTar(root.right, target);
        
        if(left!=null)  return left;
        
        return right;
    }
    
    public void addParent(TreeNode root, Map<TreeNode, TreeNode> map){
        if(root == null)    return;
        
        if(root.left != null)   map.put(root.left, root);
        if(root.right != null)  map.put(root.right, root);
        
        addParent(root.left, map);
        addParent(root.right, map);
    }
}