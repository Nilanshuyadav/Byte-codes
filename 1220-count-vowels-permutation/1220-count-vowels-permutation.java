class Solution {  
    long[][] dp;
    int mod = 1000000007;
    
    public int countVowelPermutation(int n) {
        
        dp = new long[26][n+1];
        
        
        Map<Character,List<Character>> map = new HashMap<>();
        
        map.put('a',new ArrayList<Character>(List.of('e')));
        map.put('e',new ArrayList<Character>(List.of('a','i')));
        map.put('i',new ArrayList<Character>(List.of('a','e','o','u')));
        map.put('o',new ArrayList<Character>(List.of('i','u')));
        map.put('u',new ArrayList<Character>(List.of('a')));
        
        List<Character> al = new ArrayList<>(List.of('a','e','i','o','u'));
        
        long sum = 0;
        
        for(char ch : al)
            sum += function(ch,map,n)%mod;
        
        return (int)(sum%mod);    
    }
    
    public long function(Character ch, Map<Character,List<Character>> map,int n){
        if(1 == n) return dp[ch - 'a'][1] = (long)1;
        
        if(dp[ch-'a'][n] != 0) return dp[ch-'a'][n];
        
        long sum = 0;
        
        for(char alp : map.get(ch))
            sum += function(alp,map,n-1)%mod;
        
        
        return dp[ch - 'a'][n] = sum;
    }
}