class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int[] arr = new int[58];
        
        for(int ind=0; ind<n; ind++)
            arr[s.charAt(ind)-'A']++;
        
        int sum=0;
        
        for(int ind : arr){
            if(ind%2==0) sum+=ind;
            else sum += ind-1;
        }
        
        return sum==n? sum: sum+1;
    }
}