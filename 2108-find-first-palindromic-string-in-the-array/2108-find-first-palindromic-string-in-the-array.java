class Solution {
    public String firstPalindrome(String[] words) {
        for(String st : words){
            if(isPallindrome(st))
                return st;
        }

        return "";
    }

    public boolean isPallindrome(String st){
        int l=0, h=st.length()-1;
        while(l<h && st.charAt(l) == st.charAt(h)){
            l++;
            h--;
        }

        return l>=h;
    }
}