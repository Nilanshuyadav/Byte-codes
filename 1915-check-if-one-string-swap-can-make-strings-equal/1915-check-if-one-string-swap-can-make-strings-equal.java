class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        Integer i1=null, i2=null;
        if(n != s2.length()) return false;

        for(int i=0; i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(i1!=null && i2!=null) return false;
                i2 = i1;
                i1 = i;

                if(i1!=null && i2!=null){

                    if(s1.charAt(i1) != s2.charAt(i2) || s1.charAt(i2) != s2.charAt(i1)) return false;
                }
            }
        }

        return (i1==null && i2==null) || (i1!=null && i2!=null);
    }
}