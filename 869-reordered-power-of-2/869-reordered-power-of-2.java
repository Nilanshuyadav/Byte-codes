class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] arr = new int[11];
        arr = hashing(n);
        int power = 1;
        for(int i=0;i<=31;i++){
            int[] toCheck = hashing(power);
            if(equal(arr,toCheck))
                return true;
            
            power *= 2;
        }
        
        return false;
    }
    
    public int[] hashing(int n){
        int[] arr = new int[11];
        while(n>0){
            arr[n%10]++;
            n /= 10;
        }
        return arr;
    }
    
    public boolean equal(int[] arr, int[] toCheck){
        for(int i=0;i<11;i++)
            if(arr[i] != toCheck[i])
                return false;
        return true;
    }
}