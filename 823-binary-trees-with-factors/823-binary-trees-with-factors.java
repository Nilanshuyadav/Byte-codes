class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n  = arr.length;
        Arrays.sort(arr);
        
        Map<Integer,Long> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
            map.put(arr[i],(long)1);
        
        for(int i=1;i<n;i++){
            long cnt = 0;
            
            for(int j = 0;j<i;j++){
                if(arr[i] % arr[j] == 0){
                    int temp = arr[i] / arr[j];
                    
                    if(map.containsKey(temp)){
                        cnt += (map.get(arr[j]) * map.get(temp));
                    }
                }
            }
            
            map.put(arr[i],map.get(arr[i])+cnt);
        }
        
        long sum = 0;
        
        for(int i = 0;i<n;i++)
            sum += map.get(arr[i]);
        
        return (int)(sum%1000000007);
    }
}