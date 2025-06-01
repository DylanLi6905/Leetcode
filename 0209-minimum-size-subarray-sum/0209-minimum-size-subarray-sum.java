class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int currentSum = 0, left = 0;
        boolean changed = false;
        for(int right = 0; right < nums.length; right++){
            currentSum += nums[right];
            if(currentSum >= target){
                changed = true;
                smallest = Math.min(smallest, right - left+1);
            }
            while(currentSum >= target){
                if(currentSum >= target){
                changed = true;
                smallest = Math.min(smallest, right - left+1);
                }
                currentSum -= nums[left];
                left++;
                
            }
        }
        if(changed){
            return smallest;
        }
        return 0;
    }
}