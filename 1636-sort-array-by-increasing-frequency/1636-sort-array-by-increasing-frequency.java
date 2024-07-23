class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int mapsize = map.size();
        MyPair[] temp = new MyPair[mapsize];
        int ind=0;
        
        for(int i : map.keySet()){
            temp[ind++] = new MyPair(i, map.get(i));    
        }
        
        Arrays.sort(temp, (a,b) -> a.val!=b.val ? a.val-b.val : b.key-a.key);
        
        ind=0;
        for(int i=0; i<mapsize; i++){
            while(temp[i].val-->0){
                nums[ind++] = temp[i].key;  
            }
        }
        
        return nums;
    }
}

class MyPair{
    int key, val;
    
    public MyPair(int key, int val){
        this.key = key;
        this.val = val;
    }
}