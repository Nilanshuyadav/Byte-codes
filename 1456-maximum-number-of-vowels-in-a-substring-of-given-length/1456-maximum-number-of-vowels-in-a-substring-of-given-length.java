class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        List<Integer> al = new ArrayList<>();
        int n = s.length(), pos, temp;
        char ch;
        
        for(int ind=0; ind<n; ind++){
            ch = s.charAt(ind);
            
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                al.add(ind);
                temp = ind-k;
                
                pos = findPos(al, temp);
                
                max = Math.max(max, al.size()-pos);
            }
        }
        
        return max;
    }
    
    
    public int findPos(List<Integer> al, int temp){
        int l=0, h=al.size()-1, m, max=-1;
        
        while(l<=h){
            m = l + (h-l)/2;
            
            if(al.get(m) == temp){
                max = Math.max(max, m);
                l = m+1;
            }
            else if(al.get(m) < temp){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        
        return max==-1 ? h+1 : max+1;
    }
}