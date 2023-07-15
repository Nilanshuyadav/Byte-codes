class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int num, max=0;
        
        for(int ind=0; ind<arr.length; ind++){
            num = arr[ind];
            
            if(map.containsKey(num-diff)){
                map.put(num, map.get(num-diff)+1);
            }
            else{
                map.put(num, 1);
            }
            
            max = Math.max(max, map.get(num));
        }
        
        return max;
    }
}