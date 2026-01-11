class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = 0, n = 0;
        while(m < nums1.length && n < nums2.length){
            if(nums1[m] == nums2[n]){
                return nums1[m];
            } else if (nums1[m] > nums2[n]){
                n++;
            } else {
                m++;
            }
        }
        return -1;
    }
}