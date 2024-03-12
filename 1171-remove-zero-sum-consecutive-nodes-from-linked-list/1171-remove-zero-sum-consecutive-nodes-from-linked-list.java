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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1, head), curr = head;
        
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        
        while(curr != null){
            sum += curr.val;
            
            if(map.containsKey(sum)){
                ListNode temp = map.get(sum);
                temp = temp.next;
                
                int temp_sum = sum + temp.val;
                
                while(temp_sum != sum){
                    map.remove(temp_sum);
                    temp = temp.next;
                    
                    temp_sum += temp.val;
                }
                
                map.get(sum).next = curr.next;
            }
            else{
                map.put(sum, curr);
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}