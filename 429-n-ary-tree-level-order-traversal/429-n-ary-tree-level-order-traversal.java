/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> al = new ArrayList<>();
            int size = q.size();
            while(size-->0){
                Node temp = q.remove();
                al.add(temp.val);
                
                for(Node i : temp.children) q.add(i);
            }
            ans.add(al);
        }
        
        return ans;
    }
}