class Solution {
    int[] memo;
    public int jump(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums.length-1, nums);
    }
    public int dp(int idx, int[] nums){
        if(idx == 0){
            return 0;
        }
        if(memo[idx] != -1) {
            return memo[idx];
        }
        int minJumps = Integer.MAX_VALUE;
        for(int i = 0; i < idx; i++) {
            if(i + nums[i] >= idx){
                int jumps = dp(i, nums);
                if (jumps != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, jumps + 1);
                }
            }
        }
        memo[idx] = minJumps;
        return minJumps;
    }
}