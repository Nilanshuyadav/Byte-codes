//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int min;
    public static int minSubtreeSumBST(int target, Node root) {
        // code here
        int[] arr = new int[5];
        min = Integer.MAX_VALUE;
        
        solve(root, target);
        
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    
    public static int[] solve(Node root, int target){
        if(root == null){
            return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        
        int[] left = solve(root.left, target);
        int[] right = solve(root.right, target);
        
        if(left[1] >= root.data || root.data >= right[2]){
            if(root.data == target){
                min = Math.min(min, 1);
            }
            
            return new int[]{1, root.data, root.data, root.data};
        }
        
        if(left[3] + right[3] + root.data == target){
            min = Math.min(min, left[0] + right[0] + 1);
        }
        
        return new int[]{left[0]+right[0]+1, Math.max(root.data, Math.max(left[1], right[1])), Math.min(root.data, Math.min(left[2], right[2])), left[3]+right[3]+root.data};
    }
}
