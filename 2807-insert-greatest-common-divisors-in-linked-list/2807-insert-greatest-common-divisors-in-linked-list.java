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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head, h = head, temp;
        
        while(curr.next!=null){
            temp = new ListNode(gcd(curr.val, curr.next.val), curr.next);
            curr.next = temp;
            
            curr = temp.next;
        }
        
        return h;
    }
    
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        
        return gcd(b, a%b);
    }
}