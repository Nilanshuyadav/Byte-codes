class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int n = customers.length;
        
        for(int i=0; i<n; i++){
            if(grumpy[i]==0){
                sum += customers[i];
            }
        }
        
        int temp=0, max=0;
        
        for(int i=0; i<=n-minutes; i++){
            temp = 0;
            
            for(int j=i; j<i+minutes; j++){
                if(grumpy[j]==1){
                    temp += customers[j];
                }
            }
            
            max = Math.max(max, temp);
        }
        
        return sum+max;
    }
}