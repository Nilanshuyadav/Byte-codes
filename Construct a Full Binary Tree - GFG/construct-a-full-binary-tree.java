//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    int lvl;
    int stop;
    int index;
    
    int[] preo, preoM;
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        lvl = (int)(Math.log(size)/Math.log(2));
        stop = size/2 + 1;
        index = 1;
        
        preo = pre;
        preoM = preM;
        
        Node root = new Node(pre[0]);
        solve(root, root, 0);
        
        return root;
    }
    
    public void solve(Node n1, Node n2, int temp_lvl){
        if(temp_lvl == lvl || index==stop)
            return;
            
        n1.left = new Node(preo[index]);
        n2.right = new Node(preoM[index]);
        
        index++;
        solve(n1.left, n2.right, temp_lvl+1);
        
        n1.right = new Node(preo[index]);
        n2.left = new Node(preoM[index]);
        
        index++;
        solve(n1.right, n2.left, temp_lvl+1);
    }
    
}