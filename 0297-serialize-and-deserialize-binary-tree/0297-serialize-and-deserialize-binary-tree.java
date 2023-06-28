/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;
        
        q.add(root);
        
        while(!q.isEmpty()){
            temp = q.remove();
            
            sb.append(',');
            if(temp == null){
                sb.append('#');
                continue;
            }
            
            sb.append(String.valueOf(temp.val));
            
            q.add(temp.left);
            q.add(temp.right);
        }
        
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int n = arr.length, ind=0, k;
        if(n <= 1)  return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode curr = new TreeNode(Integer.valueOf(arr[ind++])), temp;
        q.add(curr);
        
        while(!q.isEmpty()){
            temp = q.remove();
            if(temp == null) continue;
            
            k=2;
            
            while(k-->0){
                if(arr[ind].equals("#")){
                    if((ind&1)!=0){
                        temp.left = null;
                    }
                    else{
                        temp.right = null;
                    }
                }
                else{
                    if((ind&1)!=0){
                        temp.left = new TreeNode(Integer.valueOf(arr[ind]));
                    }
                    else{
                        temp.right = new TreeNode(Integer.valueOf(arr[ind]));
                    }
                }
                
                ind++;
            }            
            
            q.add(temp.left);
            q.add(temp.right);
        }
        
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));