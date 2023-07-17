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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(reverse(l1), reverse(l2));
    }
    
    public ListNode reverse(ListNode l1){
        if(l1 == null){
            return null;
        }
        
        ListNode curr = l1, next = l1.next, pre = null;
        
        while(next != null){
            curr.next = pre;
            
            pre = curr;
            curr = next;
            next = curr.next;
        }
        
        curr.next = pre;
        return curr;
    }
    
    public ListNode add(ListNode l1, ListNode l2){
        ListNode curr1=l1, curr2=l2, curr=null, toAdd;
        int carry=0, sum=0;
        
        while(curr1!=null && curr2!=null){
            sum = curr1.val + curr2.val + carry;
            
            if(sum>9){
                carry = 1;
                sum %= 10;
            }
            else{
                carry = 0;
            }
            
            toAdd = new ListNode(sum);
            
            if(curr!=null){
                toAdd.next = curr;
            }
            
            curr = toAdd;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        while(curr1!=null){
            sum = curr1.val+carry;
            
            if(sum>9){
                carry = 1;
                sum %= 10;
            }
            else{
                carry = 0;
            }
            
            toAdd = new ListNode(sum);
            
            if(curr!=null){
                toAdd.next = curr;
            }
            
            curr  = toAdd;
            
            curr1 = curr1.next;
        }
        
        while(curr2!=null){
            sum = curr2.val+carry;
            
            if(sum>9){
                carry = 1;
                sum %= 10;
            }
            else{
                carry = 0;
            }
            
            toAdd = new ListNode(sum);
            
            if(curr!=null){
                toAdd.next = curr;
            }
            
            curr  = toAdd;
            
            curr2 = curr2.next;
        }
        
        if(carry == 1){            
            toAdd = new ListNode(carry, curr);
            curr = toAdd;
        }
        
        return curr;
    }
}