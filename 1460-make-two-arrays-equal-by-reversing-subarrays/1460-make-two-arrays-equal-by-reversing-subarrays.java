class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] fre = new int[1001];
        int n = arr.length;
        
        for(int i : target){
            fre[i]++;
        }
        
        for(int i : arr){
            fre[i]--;
        }
        
        for(int i : fre){
            if(i!=0)
                return false;
        }
        
        return true;
    }
}