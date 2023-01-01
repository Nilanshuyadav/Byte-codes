class Solution {
    public List<String> letterCombinations(String digit) {
        int n = digit.length();
        
        if(n==0)
            return new ArrayList<>();
        
        Map<Character, List<Character>> map = new HashMap<>();
        
        List<Character> al = new ArrayList<>();
        int cnt=1;
        
        for(char ch='a'; ch<='o'; ch++){
            al.add(ch);
            if(cnt%3==0){
                map.put((char)('0' + ((cnt/3)+1)), new ArrayList<>(al));
                al.clear();
            }
            
            cnt++;
        }
        
        al.clear();
        
        al.add('p');
        al.add('q');
        al.add('r');
        al.add('s');
        map.put('7', new ArrayList<>(al));
        
        al.clear();
        
        al.add('t');
        al.add('u');
        al.add('v');
        map.put('8', new ArrayList<>(al));
        
        al.clear();
        
        al.add('w');
        al.add('x');
        al.add('y');
        al.add('z');
        map.put('9', new ArrayList<>(al));
        
        if(n==1){
            List<String> arr = new ArrayList<>();
            for(char ch : map.get(digit.charAt(0)))
                arr.add(ch+"");
            
            return arr;
        }

        List<String> pre = new ArrayList<>();
        
        for(char ch : map.get(digit.charAt(0)))
            pre.add(ch+"");
        
        List<String> temp = new ArrayList<>();
        
        for(int ind=1; ind<n; ind++){
            List<Character> curr = map.get(digit.charAt(ind));
            
            for(String st : pre)
                for(char ch : curr)
                    temp.add(st+ch);
            
            pre = new ArrayList<>(temp);
            temp.clear();                    
        }
        
        return pre;
    }
}