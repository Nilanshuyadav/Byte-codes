class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, temp=0, max=0, j=0;
        int n = customers.length;
        
        for(int i=0; i<n; i++){
            if(grumpy[i]==0){
                sum += customers[i];
            }
            else{
                while((i-j)>=minutes){
                    if(grumpy[j]==1){
                        temp -= customers[j];
                    }
                    
                    j++;
                }
                
                temp += customers[i];
                
                max = Math.max(max, temp);
            }
        }
        
        return sum+max;
    }
}