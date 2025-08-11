class Solution {
    private int[] nums;
    private int target;
    private int[][] memo;
    private int offset;
    private int maxSum;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        maxSum = 0;
        for (int num : nums) maxSum += num;
        offset = maxSum;

        memo = new int[nums.length][2 * maxSum + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }

        return dp(0, 0);
    }
    public int dp(int i, int currentSum){
        if(i == nums.length){
            return currentSum == target ? 1 : 0;
        }
        if (memo[i][currentSum + offset] != Integer.MIN_VALUE) {
            return memo[i][currentSum + offset];
        }
        int add = dp(i + 1, currentSum + nums[i]);
        int subtract = dp(i + 1, currentSum - nums[i]);
        memo[i][currentSum + offset] = add + subtract;
        return memo[i][currentSum + offset];
    }
}