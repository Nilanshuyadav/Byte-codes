class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int a = (m+n-1)/2, b = (m+n)/2;
        double num1=0, num2=0;

        System.out.println(a+" "+b);

        int i=0, j=0;
        int min;

        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                min = nums1[i];
                i++;
            }
            else{
                min = nums2[j];
                j++;
            }
            
            a--;
            b--;

            System.out.println(a+" "+b+" "+min);
            if(a==-1){
                num1 = min;
            }

            if(b==-1){
                num2 = min;
            }
        }

        while(i<n){
            min = nums1[i];
            i++;
            a--;
            b--;

            if(a==-1){
                num1 = min;
            }

            if(b==-1){
                num2 = min;
            }
        }

        while(j<m){
            min = nums2[j];
            j++;
            a--;
            b--;

            if(a==-1){
                num1 = min;
            }

            if(b==-1){
                num2 = min;
            }
        }

        return (num1+num2)/2;
    }
}