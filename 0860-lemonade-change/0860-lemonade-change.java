class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[3];
        
        for(int i : bills){
            if(i==10){
                if(arr[0]>0){
                    arr[0]--;
                    arr[1]++;
                }
                else return false;
            }
            else if(i==20){
                if(arr[1]>0 && arr[0]>0){
                    arr[0]--;
                    arr[1]--;
                    arr[2]++;
                }
                else if(arr[0]>2){
                    arr[0] -= 3;
                    arr[2]++;
                }
                else return false;
            }
            else{
                arr[0]++;
            }
        }
        
        return true;
    }
}