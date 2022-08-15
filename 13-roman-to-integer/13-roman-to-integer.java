class Solution {
    public int romanToInt(String s) {
        
        Map<Character,Integer> map = new  HashMap<>();
        int n = s.length();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int temp1=0,temp2,sum=0,i;
        for(i=0;i<n;i++){
            temp1 = map.get(s.charAt(i));
            if(i+1<n)
                temp2 = map.get(s.charAt(i+1));
            else break;
            if(temp1 >= temp2) sum += temp1;
            else{
                sum += (temp2-temp1);
                i++;
            }
        }
        
        if(i==n-1) sum += temp1;
        return sum;
    }
}