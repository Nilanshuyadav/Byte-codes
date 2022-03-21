class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
         String[] arr = sentence.split(" ");
        int n = arr.length;
        int m = dictionary.size();
        int flg = 0;
        StringBuilder ans = new StringBuilder("");
        
        for(String st:arr){
            n = Integer.MAX_VALUE;
           for(int i=0;i<m;i++){
               if(st.indexOf(dictionary.get(i)) == 0 && dictionary.get(i).length()<n){
                   if(flg==0)
                       ans.append(dictionary.get(i) + " ");
                   else{
                       ans.delete(ans.length()-n-1,ans.length());
                       ans.append(dictionary.get(i) + " ");
                   }    
                   n = dictionary.get(i).length();
                   flg = 1;
                   
               }
           }
            if(flg != 1)
                ans.append(st + " ");
            flg = 0;
            // System.out.println(ans);
                
        }
        
        ans.deleteCharAt(ans.length()-1);
        
        return ans.toString();
        
    }
}