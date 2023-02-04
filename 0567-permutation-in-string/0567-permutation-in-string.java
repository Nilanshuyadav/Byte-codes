class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int n1=  s1.length(), n2 = s2.length();

        if(n2<n1) return false;
        for(int ind=0; ind<n1; ind++) freq[s1.charAt(ind)-'a']++;

        int[] toCheck = new int[26];

        for(int ind=0; ind<=n2; ind++){
            if(ind<n1){
                toCheck[s2.charAt(ind)-'a']++;
            }
            else{
                int inx=0;
                for(inx=0; inx<26; inx++) if(freq[inx] != toCheck[inx]) break;

                if(inx==26) return true;

                if(ind != n2){
                    toCheck[s2.charAt(ind)-'a']++;
                    toCheck[s2.charAt(ind-n1)-'a']--;
                }
            }
        }

        return false;
    }
}