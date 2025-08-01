class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0, right = 0;
        int flipped = 0;
        while(right < nums.length){
            if(nums[right] == 0 && flipped == 0){
                flipped = 1;
                right++;
            } else if (nums[right] == 0 && flipped == 1){
                flipped = 0;
                while(nums[left] != 0){
                    left++;
                }
                left++;
            } else {
                right++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}