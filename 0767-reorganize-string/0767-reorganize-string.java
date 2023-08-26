class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        
        int arr[] = new int[26], max=0;
        
        for(int ind=0; ind<n; ind++){
            arr[s.charAt(ind)-'a']++;
        }
    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]!=b[1] ? b[1]-a[1] : a[0]-b[0]);
        for(int ind=0; ind<26; ind++){
            if(arr[ind] != 0){
                max = Math.max(max, arr[ind]);
                pq.add(new int[]{ind, arr[ind]});
            }
        }
        
        if(max > (n+1)/2)
            return "";
    
        int temp[], temp2[], fre, fre2;
        char ch, ch2;
        
        StringBuilder  sb = new StringBuilder("");
        while(!pq.isEmpty()){
            temp = pq.remove();
            
            ch = (char)(temp[0]+'a');
            fre = temp[1];
            
            sb.append(ch);
            fre--;
            
            if(!pq.isEmpty()){
                temp2 = pq.remove();
                
                ch2 = (char)(temp2[0]+'a');
                fre2 = temp2[1];
                
                sb.append(ch2);
                fre2--;
                
                if(fre2>0){
                    pq.add(new int[]{temp2[0], fre2});
                }
            }
            
            if(fre>0){
                pq.add(new int[]{temp[0], fre});
            }
            
        }
        
        return sb.toString();
    }
}