class Solution {
    public int passThePillow(int n, int time) {
        int dub = (n-1)*2, temp = (time%(dub));
        return temp<n ? temp+1 : dub-temp+1;
    }
}