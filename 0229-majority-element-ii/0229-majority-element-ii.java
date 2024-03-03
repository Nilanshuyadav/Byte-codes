class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int cnt1=0, cnt2=0, can1=0, can2=0;
        
        for(int i : nums){
            if(cnt1==0 && i!=can2){
                cnt1 = 1;
                can1 = i;
            }
            else if(cnt2==0 && i!=can1){
                cnt2 = 1;
                can2 = i;
            }
            else if(i == can1){
                cnt1++;
            }
            else if(i == can2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        
        List<Integer> al = new ArrayList<>();
        
        cnt1 = 0;
        cnt2 = 0;
        for(int i : nums){
            if(i == can1) cnt1++;
            if(i == can2) cnt2++;
        }
        
        int th = nums.length/3;
        if(cnt1>th){
            al.add(can1);
        }
        if(cnt2>th && can1 != can2){
            al.add(can2);
        }
        
        return al;
    }
}