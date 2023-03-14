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
    String ans;
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        ans = "zzz";
        
        solve(root, sb);
        return ans;
    }
    
    public void solve(TreeNode root, StringBuilder sb){
        if(root.left==null && root.right==null){
            sb.append((char)(root.val+'a'));
            
            sb.reverse();
            String temp = sb.toString();
            sb.reverse();
            
            ans = ans.compareTo(temp) > 0 ? temp : ans;
            
            sb.deleteCharAt(sb.length()-1);
            
            return;
        }
        
        sb.append((char)(root.val+'a'));
        
        if(root.left != null) solve(root.left, sb);
        if(root.right != null) solve(root.right, sb);
        
        sb.deleteCharAt(sb.length()-1);
        
        
        
//         if(root.left == null){
//             return "" + solve(root.right) + (char)(root.val+'a');
//         }
//         else if(root.right == null){
//             return ""+solve(root.left)+(char)(root.val+'a');
//         }
//         else{
//             String left = ""+solve(root.left)+(char)(root.val+'a'),
//                     right = ""+solve(root.right)+(char)(root.val+'a');
            
//             if(left.compareTo(right) > 0){
//                 return right;
//             }
//             else
//                 return left;
//         }
    }
}