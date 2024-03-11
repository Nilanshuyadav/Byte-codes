class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        
        int n = s.length(), curr;
        
        for(int ind=n-1; ind>=0; ind--){
            curr = map.get(s.charAt(ind));
            
            if(curr>=sum || s.charAt(ind)==s.charAt(ind+1)){
                sum += curr;
            }
            else{
                sum -= curr;
            }
        }
        
        return sum;
    }
}