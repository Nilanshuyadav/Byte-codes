class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        
        if(n1 != n2)
            return false;
        
        int[] arr1 = new int[26];
        
        Set<Character> set1 = new HashSet<>(), set2 = new HashSet<>();
        
        for(int ind=0; ind<n1; ind++){
            set1.add(word1.charAt(ind));
            arr1[word1.charAt(ind) - 'a']++;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int ind=0; ind<26; ind++)
            if(arr1[ind] != 0)
                map.put(arr1[ind], map.getOrDefault(arr1[ind], 0)+1);
        
        Arrays.fill(arr1, 0);
        
        for(int ind=0; ind<n2; ind++){
            set2.add(word2.charAt(ind));
            
            arr1[word2.charAt(ind) - 'a']++;
        }
        
        for(int ind=0; ind<26; ind++)
            if(arr1[ind] != 0){
                if(map.containsKey(arr1[ind]) && map.get(arr1[ind])>0){
                    int temp = map.get(arr1[ind]);
                    map.put(arr1[ind], temp-1);
                }
                else
                    return false;
            }
        
        if(set1.size() != set2.size())
            return false;
        
        for(Character ch : set1){
            if(!set2.contains(ch))
                return false;
        }
        
        for(Character ch : set2)
            if(!set1.contains(ch))
                return false;
        
        return true;
    }
}