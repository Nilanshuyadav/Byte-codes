//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    Set<Node> ans = new LinkedHashSet<>();
	    
	    findLeft(node.left, ans);
	    if(node.left != null)   leaf(node.left, ans);
	    if(node.right != null)  leaf(node.right, ans);
	    findRight(node.right, ans);
	    
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    list.add(node.data);
	    
	    for(Node nod : ans){
	        list.add(nod.data);
	    }
	    
	    return list;
	}
	
	void findLeft(Node node, Set<Node> ans){
	    if(node == null) return;
	    
	    ans.add(node);
        if(node.left==null)
            findLeft(node.right, ans);
        else
            findLeft(node.left, ans);
	}
	
	void leaf(Node node, Set<Node> ans){
	    if(node.left == null && node.right == null){
	        ans.add(node);
	        return;
	    }
	    
	    if(node.left != null)   leaf(node.left, ans);
	    if(node.right != null)  leaf(node.right, ans);
	}
	
	void findRight(Node node, Set<Node> ans){
	    if(node == null) return;
	    
	    if(node.right==null)
	        findRight(node.left, ans);
	   else
	        findRight(node.right, ans);
	    ans.add(node);
	}
}

// 4 10 N 5 5 N 6 7 N 8 8 N 8 11 N 3 4 N 1 3 N 8 6 N 11 11 N 5 8
