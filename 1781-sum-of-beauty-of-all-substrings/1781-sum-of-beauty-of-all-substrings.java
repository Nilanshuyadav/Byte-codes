class Solution {
    public int beautySum(String s) {
        int[] arr = new int[26];
        int n = s.length(), sum=0;
        
        int max, min;
        
        int ch;
        
        for(int i=0; i<n; i++){
            Arrays.fill(arr, 0);
            
            for(int j=i; j<n; j++){
                ch = s.charAt(j)-'a';
                
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;

                
                arr[ch]++;
                
                for(int ind :arr){
                    if(ind==0)
                        continue;
                    
                    max = Math.max(max, ind);
                    min = Math.min(min, ind);  
                }
                
                sum += max-min;
            }
        }
        
        return sum;
    }
}