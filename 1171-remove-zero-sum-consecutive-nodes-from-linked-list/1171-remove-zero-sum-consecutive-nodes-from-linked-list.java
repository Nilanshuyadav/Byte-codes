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
        ListNode dummy = new ListNode(-1001, head), curr=head;
        
        int ind=0;
        List<int[]> al = new ArrayList<>();
        Map<Integer, Pair> map = new HashMap<>();
        
        int sum = 0;
        map.put(0, new Pair(0, dummy));
        
        while(curr!=null){
            sum += curr.val;
            ind++;
            
            if(map.containsKey(sum)){
                Pair temp = map.get(sum);
                
                
                if(isValid(temp.ind, al)){
                   temp.curr.next = curr.next;
                    
                    al.add(new int[]{temp.ind+1, ind});
                }
                else{
                    map.put(sum, new Pair(ind, curr));
                }
            }
            else{
                map.put(sum, new Pair(ind, curr));        
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    public boolean isValid(int tar, List<int[]> al){
        for(int[] i : al){
            if(i[0]<=tar && tar<=i[1]) return false;
        }
        
        return true;
    }
}

class Pair{
    int ind;
    ListNode curr;
    
    public Pair(int ind, ListNode curr){
        this.ind = ind;
        this.curr = curr;
    }
}










// [1,2,-3,3,1]
// [1,2,3,-3,4]
// [1,2,3,-3,-2]
// [1,3,2,-3,-2,5,5,-5,1]
// [0,0]
// [6,-5,3,2,-3,-2,5,5,-5,1]