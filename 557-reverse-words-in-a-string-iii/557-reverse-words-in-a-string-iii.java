class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ",-1);
        StringBuilder ans = new StringBuilder("");
        
        for(String st : arr){
            StringBuilder sb = new StringBuilder(st);
            int low=0, high = sb.length()-1;
            
            while(low<high){
                char temp = sb.charAt(low);
                sb.setCharAt(low++,sb.charAt(high));
                sb.setCharAt(high--,temp);
            }
            
            ans.append(sb.toString() + " ");
        }
        
        ans.delete(ans.length()-1,ans.length());
        
        return ans.toString();
    }
}