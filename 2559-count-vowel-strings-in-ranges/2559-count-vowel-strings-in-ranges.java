class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Integer> al = new ArrayList<>();
        int n = queries.length;
        
        int[] ans = new int[n];
        char ch1, ch2;
        
        for(int ind=0; ind<words.length; ind++){
            ch1 = words[ind].charAt(0);
            ch2 = words[ind].charAt(words[ind].length()-1);
            
            if((ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o' || ch1=='u') && (ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u')){
                al.add(ind);
            }
        }
        
        int al_size = al.size();
        
        int from, to, pos_to, pos_from, m=al.size();
        for(int ind=0; ind<n; ind++){
            from = queries[ind][0];
            to = queries[ind][1];
            
            pos_to = findPos(al, to, m);
            pos_from = findPos(al, from, m);

            if(pos_from>=al_size){
                ans[ind] = 0;
            }
            else if(al.get(pos_from)==from && pos_to<al_size && al.get(pos_to)==to){
                ans[ind] = pos_to - pos_from+1;
            }
            else if(al.get(pos_from)>from && pos_to<al_size && al.get(pos_to)==to){
                ans[ind] = pos_to - pos_from+1;
            }
            else if(al.get(pos_from)==from && (pos_to>=al_size || al.get(pos_to)>to)){
                ans[ind] = pos_to - pos_from;
            }
            else{
                ans[ind] = pos_to - pos_from;
            }
        }
        
        return ans;
        
        //[[0,2],[1,6],[0,6],[1,3]]
    }
    
    public int findPos(List<Integer> al, int target, int n){
        int l=0, h=n-1, m;
        
        while(l<=h){
            m = l+(h-l)/2;
            
            if(al.get(m) == target) return m;
            else if(al.get(m) > target) h=m-1;
            else l=m+1;
        }
        
        return h+1;
    }
}