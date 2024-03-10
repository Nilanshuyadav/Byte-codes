class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length, i=0, j=0;
        int a = (n+m)/2, b = (n+m-1)/2, ind=-1, num;
        
        double n1=0, n2=0;
        
        while(i<n && j<m && ind<a){
            ind++;
            
            if(nums1[i] < nums2[j]){
                num = nums1[i++];    
            }
            else{
                num = nums2[j++];
            }
            
            if(ind == a){
                n1 = num;
            }
            if(ind == b){
                n2 = num;
            }
        }
        
        while(i<n && ind<a){
            ind++;
            num = nums1[i++];
            
            if(ind == a){
                n1 = num;
            }
            if(ind == b){
                n2 = num;
            }
        }
        
        while(j<m && ind<a){
            ind++;
            num = nums2[j++];
            
            if(ind == a){
                n1 = num;
            }
            if(ind == b){
                n2 = num;
            }
        }
        
        return (n1+n2)/2;
    }
}