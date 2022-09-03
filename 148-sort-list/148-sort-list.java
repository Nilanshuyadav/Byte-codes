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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode curr = head;
        List<Integer> al = new ArrayList<>();
        while(curr != null){len++; al.add(curr.val); curr = curr.next;}
        
        int[] arr = new int[len];
        int k = 0;
        for(int i : al) arr[k++] = i;
        
        merge_break(arr,0,len-1);
        
        curr = head;
        for(int i=0;i<len;i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        
        return head.next;
    }
    
    public void merge_break(int[] arr, int low, int high){
        if(low>=high) return;
        
        int mid = (low+high)/2;
        
        merge_break(arr,low,mid);
        merge_break(arr,mid+1,high);
        
        merge(arr,low,mid,high);
    }
    
    public void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        
        int[] copy_arr = new int[high-low+1];
        int k=0;
        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){ copy_arr[k++] = arr[i]; i++;}
            else {copy_arr[k++] = arr[j]; j++;}
        }
        
        while(i<=mid){copy_arr[k++] = arr[i]; i++;}
        while(j<=high){copy_arr[k++] = arr[j]; j++;}
        
        k = low;
        for(int val : copy_arr)
            arr[k++] = val;
    }
}