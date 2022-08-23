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
    public boolean isPalindrome(ListNode head) {  
        ListNode curr = head;
        int len = 0;
        while(curr!= null){
            len++;
            curr = curr.next;
        }   
        
        int[] arr = new int[len];
        int k=0;
        curr = head;
        
        while(curr != null){
            arr[k] = curr.val;
            curr = curr.next;
            k++;
        }
        
        int low = 0, high = len-1;
        
        while(low<high){
            if(arr[low] != arr[high]) return false;
            low++;
            high--;
        }
        
        return true;
    }
}