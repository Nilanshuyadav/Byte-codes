class Solution {
    public List<String> letterCombinations(String s) {
        int n = s.length();
        
        if(n==0){
            return new ArrayList<>();
        }
        
        Map<Character, List<String>> map = new HashMap<>();
    
        char ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(!map.containsKey(ch)){
                List<String> temp;
                
                switch(ch){
                    case '2' :
                        temp = new ArrayList<>(Arrays.asList("a","b","c"));
                        break;
                    case '3' :
                        temp = new ArrayList<>(Arrays.asList("d","e","f"));
                        break;
                    case '4' :
                        temp = new ArrayList<>(Arrays.asList("g","h","i"));
                        break;
                    case '5' :
                        temp = new ArrayList<>(Arrays.asList("j","k","l"));
                        break;
                    case '6' :
                        temp = new ArrayList<>(Arrays.asList("m","n","o"));
                        break;
                    case '7' :
                        temp = new ArrayList<>(Arrays.asList("p","q","r","s"));
                        break;
                    case '8' :
                        temp = new ArrayList<>(Arrays.asList("t","u","v"));
                        break;
                    default :    
                        temp = new ArrayList<>(Arrays.asList("w","x","y","z"));
                }
                
                map.put(ch, temp);
            }
        }
        
        List<String> temp2, temp1 = map.get(s.charAt(0)), ans = new ArrayList<>();
        String st;
        
        for(int ind=1; ind<n; ind++){
            ch = s.charAt(ind);
            
            temp2 = map.get(ch);
            
            for(String s1 : temp1){
                for(String s2 : temp2){
                    st = s1+s2;
                    
                    ans.add(st);
                }
            }
            
            temp1 = ans;
            ans = new ArrayList<>();            
        }
        
        return temp1;
            
    }
}