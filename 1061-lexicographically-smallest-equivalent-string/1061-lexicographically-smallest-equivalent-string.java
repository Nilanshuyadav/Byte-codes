class Solution {
    int[] arr = new int[26];

    int get(int x) {
        return x == arr[x] ? x : (arr[x] = get(arr[x]));
    }
    
    void solve(int x, int y) {
        x = get(x);
        y = get(y);
        if (x != y) {
            if (x < y)  arr[y] = x;
            else arr[x] = y;
        }
        return;
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++)  arr[i] = i;
        for (int i = 0; i < s1.length(); i++) solve(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        for (int i = 0; i < baseStr.length(); i++) {
            sb .append((char)(get(baseStr.charAt(i) - 'a') + 'a'));
        }
        return sb.toString();
    }
}