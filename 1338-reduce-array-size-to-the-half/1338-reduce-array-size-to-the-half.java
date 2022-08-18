class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        
        int[] freq = new int[map.size()];
        int k =0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            freq[k] = entry.getValue();
            k++;
        }
        
        Arrays.sort(freq);
        
        k = 0;
        int n1 = n/2;
        for(int i=freq.length-1;i>=0;i--){
            if(n-freq[i]-k <= n1) return freq.length-i;
            k += freq[i];
        }
        return 0;
    }
}