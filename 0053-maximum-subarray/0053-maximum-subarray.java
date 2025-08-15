class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int maxSeen = Integer.MIN_VALUE;
        for(int num : nums){
            curr += num;
            if(curr < 0){
                maxSeen = Math.max(maxSeen, curr);
                curr = 0;
            } else {
                maxSeen = Math.max(maxSeen, curr);
            }
        }
        return maxSeen;
    }
}