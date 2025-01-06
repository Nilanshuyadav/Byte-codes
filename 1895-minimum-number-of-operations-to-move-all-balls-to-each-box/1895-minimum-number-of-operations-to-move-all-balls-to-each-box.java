class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] preSum = new int[n];
        int steps = boxes.charAt(0)=='1'?1:0;

        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + steps;

            if(boxes.charAt(i) == '1') steps++;

            System.out.print(preSum[i]+" ");
        }

        int sum = 0;
        steps = boxes.charAt(n-1)=='1'?1:0;

        for(int i=n-2; i>=0; i--){
            sum += steps;
            preSum[i] += sum;

            if(boxes.charAt(i) == '1') steps++;
        }

        return preSum;
    }
}