class Solution {
    private int[] nums;
    public int missingElement(int[] nums, int k) {
        this.nums = nums;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(miss(mid) < k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left - 1] + k - miss(left - 1);
    }
    public int miss(int i) {
        return nums[i] - nums[0] - i;
    }
}