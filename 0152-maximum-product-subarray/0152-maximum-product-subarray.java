class Solution {
    public int maxProduct(int[] nums) {
        int first_negative=-5, count_negative=0;
        int product=1, max=Integer.MIN_VALUE, neg_index=-1;
        
        for(int ind=0; ind<nums.length; ind++){
            if(nums[ind]==0){
                product = 1;
                first_negative=-5;
                count_negative=0;
                max = Math.max(max, 0);
                continue;
            }    
            
            if(nums[ind]<0){
                count_negative++;
                if(first_negative==-5){
                    first_negative = product*nums[ind];
                    neg_index = ind;
                }
            }
            
            product *= nums[ind];
            
            if(count_negative%2==0){
                max = Math.max(max, product);
            }
            else{
                max = Math.max(max, ind==neg_index?product:product/first_negative);
            }
        }
        
        return max;
    }
}