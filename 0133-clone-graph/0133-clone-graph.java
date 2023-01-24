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
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        return copy(node, new HashMap<>());
    }
    
    public Node copy(Node node, Map<Integer, Node> map){
        Node temp = new Node(node.val);
        List<Node> temp_neighbours = temp.neighbors;
        
        map.put(node.val, temp);
        
        for(Node ind : node.neighbors){
            if(!map.containsKey(ind.val))
                copy(ind, map);
            temp_neighbours.add(map.get(ind.val));
        }
        
        return temp;
    }
}