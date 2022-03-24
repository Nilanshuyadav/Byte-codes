class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        
        int[] arr = new int[58];
        
        for(int i=0;i<n;i++)
            arr[s.charAt(i)-'A']++;
        
        int sum = 0;
        
        for(int i=0;i<58;i++){
            if(arr[i]%2!=0) sum += arr[i]-1;
            else sum += arr[i];
        }
        
        if(sum == n)
            return sum;
        else return sum+1;
    }
}