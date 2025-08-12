class Solution {
    private int[] nums;
    private int n;
    private Boolean[][] memo;
    private int t;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total % 2 == 1){
            return false;
        } else {
            memo = new Boolean[n][total / 2 + 1];
            t = total / 2;
            return dp(0, 0);
        }
    }
    public boolean dp(int i, int sum){
        if (sum == t) return true;
        if (i >= n || sum > t){
            return false;
        } 
        if (memo[i][sum] != null){
            return memo[i][sum];
        }
        boolean take = dp(i + 1, sum + nums[i]);
        boolean skip = dp(i + 1, sum);
        return memo[i][sum] = take || skip;

    }
}