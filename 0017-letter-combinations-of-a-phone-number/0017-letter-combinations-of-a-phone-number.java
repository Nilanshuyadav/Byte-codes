class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        
        if(n==0) return new ArrayList<>();
        
        Map<Character, List<String>> map = new HashMap<>();
        
        for(char ch='2'; ch<='9'; ch++){
            List<String> al;
            
            switch(ch){
                case '2':
                    al = new ArrayList(Arrays.asList("a", "b", "c"));
                    break;
                case '3':
                    al = new ArrayList(Arrays.asList("d", "e", "f"));
                    break;
                case '4':
                    al = new ArrayList(Arrays.asList("g", "h", "i"));
                    break;
                case '5':
                    al = new ArrayList(Arrays.asList("j", "k", "l"));
                    break;
                case '6':
                    al = new ArrayList(Arrays.asList("m", "n", "o"));
                    break;
                case '7':
                    al = new ArrayList(Arrays.asList("p", "q", "r", "s"));
                    break;
                case '8':
                    al = new ArrayList(Arrays.asList("t", "u", "v"));
                    break;
                case '9':
                    al = new ArrayList(Arrays.asList("w", "x", "y", "z"));
                    break;
                default:
                    al = new ArrayList<>();
            }
            
            map.put(ch, al);
        }
        
        if(n==1)   return map.get(digits.charAt(0));
        
        List<String> ans=new ArrayList<>();
        List<String> al1=map.get(digits.charAt(0)) , al2;
        
        for(int ind=1; ind<n; ind++){
            al2 = map.get(digits.charAt(ind));
            ans = new ArrayList<>();
            
            for(String st1 : al1){
                for(String st2 : al2){
                    ans.add(st1+st2);
                }
            }
            
            al1 = ans;
        }
        
        return ans;
    }
}