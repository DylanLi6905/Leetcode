class Solution {
    int[] nums;
    int[] multipliers;
    int n;
    int m;
    int[][] memo;
    public int maximumScore(int[] nums, int[] multipliers) {
        //Only choose first or last from nums
        //Goal : Max score after m operations
        this.nums = nums;
        this.multipliers = multipliers;
        n = nums.length;
        m = multipliers.length;
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0);
    }
    public int dp(int left, int mult){
        if(mult == m){
            return 0;
        }
        if(memo[left][mult] != -1){
            return memo[left][mult];
        }
        //Recurrence is simply left or right
        int res = nums[left] * multipliers[mult] + dp(left + 1, mult + 1);
        res = Math.max(res, nums[n - (mult - left) - 1] * multipliers[mult] + dp(left, mult + 1));
        return memo[left][mult] = res;
    }
}