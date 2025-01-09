class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt=0;

        for(String st : words){
            if(st.indexOf(pref) == 0) cnt++;
        } 

        return cnt;
    }
}