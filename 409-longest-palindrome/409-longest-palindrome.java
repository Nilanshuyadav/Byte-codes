class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int[] arr = new int[52];
        
        for(int ind=0; ind<n; ind++){
            char ch = s.charAt(ind);
            if(ch<91) arr[s.charAt(ind)-'A']++;
            else arr[26+s.charAt(ind)-'a']++;
        }
        
        for(int ind=0; ind<52; ind++)
            System.out.println(ind + "->" + arr[ind]);
        
        int sum=0;
        
        for(int ind : arr){
            if(ind%2==0) sum+=ind;
            else sum += ind-1;
        }
        
        return sum==n? sum: sum+1;
    }
}