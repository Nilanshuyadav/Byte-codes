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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int r1=0, r2=m-1, c1=0, c2=n-1;
        ListNode curr = head;
        int ind;
        
        int[][] ans = new int[m][n];
        
        for(int i[] : ans) Arrays.fill(i, -1);
        
        while(curr != null){
            ind = c1;
            while(ind<c2 && curr!=null){
                ans[r1][ind++] = curr.val;
                curr = curr.next;
            }
            
            ind = r1;
            while(ind<=r2 && curr!=null){
                ans[ind++][c2] = curr.val;
                curr = curr.next;
            }
            
            ind = c2-1;
            while(c1<=ind && curr!=null){
                ans[r2][ind--] = curr.val;
                curr = curr.next;
            }
            
            ind = r2-1;
            while(r1<ind && curr!=null){
                ans[ind--][c1] = curr.val;
                curr = curr.next;
            }
            
            r1++;
            r2--;
            c1++;
            c2--;
        }
        
        return ans;
    }
}