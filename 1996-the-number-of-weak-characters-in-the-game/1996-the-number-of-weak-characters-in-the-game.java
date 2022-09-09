class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        Arrays.sort(p,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]>b[0]) return 1;
                else if(a[0]<b[0]) return -1;
                else return b[1]-a[1];
            }
        });
        
        int max = 0;
        int cnt = 0;
        
        for(int i=p.length-1;i>=0;i--){
            if(p[i][1]<max) cnt++;
            else max = p[i][1];       
        }
        
        return cnt;
    }
}