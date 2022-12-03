class Solution {
    public String frequencySort(String s) {
        Pair[] arr = new Pair[123];
        
        for(int ind=0; ind<123; ind++)
            arr[ind] = new Pair(0,(char)(ind+'0'));
        
        for(int ind=0; ind<s.length(); ind++)
            arr[s.charAt(ind)-'0'].cnt++;
        
        Arrays.sort(arr, (a,b) -> b.cnt - a.cnt);

        StringBuilder sb = new StringBuilder("");

        for(Pair p : arr){
            if(p.cnt != 0){
                int temp = p.cnt;
                while(temp-->0)
                    sb.append(p.ch);
            }
        }
        
        return sb.toString();
    }
}

class Pair{
    int cnt;
    char ch;
    public Pair(int cnt, char ch){
        this.cnt = cnt;
        this.ch = ch;
    }
}