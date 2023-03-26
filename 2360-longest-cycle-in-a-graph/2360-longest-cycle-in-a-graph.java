class Solution {
    public int longestCycle(int[] edges) {
        int max = -1;
        int timeStep = 1;
        int[] node = new int[edges.length];

        for (int ind = 0; ind < edges.length; ind++) {
            if (node[ind] > 0)
                continue;
            final int startTime = timeStep;
            int u = ind;
            while (u != -1 && node[u] == 0) {
                node[u] = timeStep++;
                u = edges[u];
            }
            if (u != -1 && node[u] >= startTime)
                max = Math.max(max, timeStep - node[u]);
        }

        return max;
    }
}