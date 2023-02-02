class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        
        if(n==1)
            return true;
        
        int[] arr = new int[26];
        
        for(int ind=0; ind<26; ind++){
            arr[order.charAt(ind)-'a'] = ind;
        }
        
        for(int ind=1; ind<n; ind++){
            if(pre_greater(new StringBuilder(words[ind-1]), new StringBuilder(words[ind]), arr))
                return false;
        }
        
        return true;
    }
    
    public boolean pre_greater(StringBuilder pre, StringBuilder curr, int[] arr){
        int pre_len = pre.length(), curr_len = curr.length();
        
        for(int ind=0; ind<Math.min(pre_len, curr_len); ind++){
            if(pre.charAt(ind)!=curr.charAt(ind)){
                if(arr[pre.charAt(ind)-'a'] > arr[curr.charAt(ind)-'a'])
                    return true;
                else
                    return false;
            }
        }
        
        if(pre_len<=curr_len)
            return false;
        else
            return true;
    }
}