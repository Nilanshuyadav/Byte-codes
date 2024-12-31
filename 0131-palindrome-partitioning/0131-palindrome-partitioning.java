class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        int n = s.length();

        ans = new ArrayList<>();

        helper(0, s, n, new ArrayList<>());

        return ans;
    }

    public void helper(int ind, String s, int n, List<String> al){
        if(ind == n){
            ans.add(new ArrayList<>(al));
            return;
        }

        StringBuilder sb = new StringBuilder("");

        for(int i=ind; i<n; i++){
            sb.append(s.charAt(i));

            if(isPallindrome(sb)){
                al.add(sb.toString());
                helper(i+1, s, n, al);
                al.remove(al.size()-1);
            }
        }
    }

    public boolean isPallindrome(StringBuilder s){
        int n = s.length();

        int i=0, j=n-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}