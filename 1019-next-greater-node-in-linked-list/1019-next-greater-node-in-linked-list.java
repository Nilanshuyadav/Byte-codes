/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int len = 0;
        
        if(head.next == null) return new int[1];
        
         ListNode pre = null,curr = head,nex = head.next;
        
        while(curr.next != null){
            curr.next = pre;
            pre = curr;
            curr = nex;
            nex = nex.next;
            len++;
        }
        
        curr.next = pre;
        len++;
        
        
        int[] ans= new int[len];
        int end = len-1;
        Stack<Integer> st = new Stack();
        
        while(curr!= null){
            if(st.isEmpty()){ ans[end] = 0;}
            else{
                while(!st.isEmpty() && curr.val>=st.peek()) st.pop();
                
                if(st.isEmpty()) ans[end] = 0;
                else ans[end] = st.peek();
            }
            
            st.push(curr.val);
            end--;
            
            curr = curr.next;
        }
        
        return ans;
    }
}