class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int Sum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            Sum = (Sum + nums[i])%k;
            if(Sum<0) Sum +=k;
            if(map.containsKey(Sum)){
                
                    ans = ans+map.get(Sum);
                
                
                map.put(Sum,map.get(Sum)+1);
            }else{
                map.put(Sum,1);
            }

        }
        return ans;
    }
}