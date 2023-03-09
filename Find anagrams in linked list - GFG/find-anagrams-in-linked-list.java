//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    
    static ArrayList<Node> ans;
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        StringBuilder st = new StringBuilder("");
        Node curr = head;
        
        ans = new ArrayList<>();
        
        int[] fre = new int[26];
        int n = s.length();
        
        for(int ind=0; ind<n; ind++){
            fre[s.charAt(ind) - 'a']++;    
        }
        
        while(curr!=null){
            st.append(curr.data);
            curr = curr.next;
        }
        
        StringBuilder sb = new StringBuilder("");
    
        for(int ind=0; ind<st.length(); ind++){
            if(sb.length()<n-1){
                sb.append(st.charAt(ind));
            }
            else{
                sb.append(st.charAt(ind));
                
                if(solve(fre, sb))
                    sb.setLength(0);
                else
                    sb.deleteCharAt(0);
            }
        }
        
        return ans;
    }
    
    public static boolean solve(int[] fre, StringBuilder sb){
        int[] arr = new int[26];
        int n = sb.length();
        
        for(int ind=0; ind<n; ind++){
            arr[sb.charAt(ind) - 'a']++;
        }
        
        
        for(int ind=0; ind<26; ind++){
            if(fre[ind] != arr[ind])
                return false;
        }
        
        Node head = new Node(sb.charAt(0)), curr = head;
        int ind=1;
        
        while(ind<n){
            curr.next = new Node(sb.charAt(ind++));
            curr = curr.next;
        }
        
        
        ans.add(head);
        
        return true;
    }
}