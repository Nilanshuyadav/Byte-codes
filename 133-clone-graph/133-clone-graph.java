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
    HashMap<Integer,Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        return function(node);
    }
    
    public Node function(Node node){
        Node temp = new Node(node.val);
        visited.put(node.val,temp);
        
        List<Node> al = new ArrayList<>();
        
        for(Node i: node.neighbors){
            if(visited.containsKey(i.val))
                al.add(visited.get(i.val));
            
            else
                al.add(function(i));
        }
        
        temp.neighbors = al;
        
        return temp;
    }
}