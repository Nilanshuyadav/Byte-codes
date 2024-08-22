class Solution {
    public int findComplement(int num) {
        int n = Integer.toBinaryString(num).length();
        
        int mask = (1 << n) - 1;
        return num^mask;
    }
}