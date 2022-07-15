class Solution {
    public boolean canChange(String start, String target) {
        
        StringBuilder str1 = new StringBuilder(""), str2 = new StringBuilder("");
        
        int n = start.length();
        
        ArrayList<Integer> al1 = new ArrayList<>(), al2 = new ArrayList<>();
        
        for(int i =0;i<n;i++){
            
            char ch1 = start.charAt(i);
            char ch2 = target.charAt(i);
            
            if(ch1 != '_') str1.append(ch1);
            
            if(ch1 == 'R') al1.add(i);
            
            if(ch2 != '_') str2.append(ch2);
            
            if(ch2 == 'R') al2.add(i);
        }
        
        if(!str1.toString().equals(str2.toString())) return false;
        
        for(int i = 0;i<al1.size();i++)
            if(al1.get(i) > al2.get(i)) return false;
        
        al1.clear();
        al2.clear();
        
        for(int i =0;i<n;i++){
            if(start.charAt(i) == 'L') al1.add(i);
            if(target.charAt(i) == 'L') al2.add(i);
        }
        
        for(int i =0;i<al1.size();i++)
            if(al1.get(i) < al2.get(i)) return false;
        
        return true;
    }
}