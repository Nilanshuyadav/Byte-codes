/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)    return null;
        
        if(!map.containsKey(node.val)){
            map.put(node.val, new Node(node.val, new ArrayList<>()));
        }
        else{
            return map.get(node.val);
        }
        
        List<Node> neighbors_copy = map.get(node.val).neighbors, temp = node.neighbors;
        
        for(Node ind : temp){
            neighbors_copy.add(cloneGraph(ind));
        }
        
        return map.get(node.val);
    }
}