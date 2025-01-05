class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] segment = new int[n + 1];

        for (int[] segment_tmp : shifts) {
            int start = segment_tmp[0], end = segment_tmp[1], dir = segment_tmp[2];
            segment[start] += (dir == 1 ? 1 : -1);
            if (end + 1 < n) segment[end + 1] -= (dir == 1 ? 1 : -1);
        }

        int currentSegment = 0;
        for (int i = 0; i < n; ++i) {
            currentSegment += segment[i];
            segment[i] = currentSegment;
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            int netShift = (segment[i] % 26 + 26) % 26;
            result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return result.toString();
    }
}