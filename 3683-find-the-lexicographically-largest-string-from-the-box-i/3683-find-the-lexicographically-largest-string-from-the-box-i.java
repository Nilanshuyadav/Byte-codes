class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();

        if(numFriends==1) return word;

        char mac_ch = 'a';
        List<Integer> al = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(word.charAt(i)>mac_ch){
                mac_ch = word.charAt(i);
            }
        }

        for(int i=0; i<n; i++){
            if(mac_ch == (char)word.charAt(i)){
                al.add(i);
            }
        }

        List<String> temp_al = new ArrayList<>();
        int rem;
        for(int i : al){
            if(i>=numFriends-1){
                temp_al.add(word.substring(i));
            }
            else{
                rem = numFriends-i-1;

                if(rem<=(n-1-i)){
                    temp_al.add(word.substring(i, (n-rem)));
                }
            }
        }

        Collections.sort(temp_al);
        return temp_al.get(temp_al.size()-1);
    }
}