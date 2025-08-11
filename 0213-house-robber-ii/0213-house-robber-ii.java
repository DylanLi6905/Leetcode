class Solution {
    private int[] memo;
    private int[] nums;
    private int start, end;

    public int rob(int[] nums) {
        int m = nums.length;
        if (m == 0) return 0;
        if (m == 1) return nums[0];
        
        this.nums = nums;
        this.start = 0;
        this.end = m - 2;
        memo = new int[m];
        Arrays.fill(memo, -1);
        int case1 = dp(0);

        this.start = 1;
        this.end = m - 1;
        memo = new int[m];
        Arrays.fill(memo, -1);
        int case2 = dp(1);

        return Math.max(case1, case2);
    }

    public int dp(int i) {
        if (i > end) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = Math.max(dp(i + 1), dp(i + 2) + nums[i]);
        return memo[i];
    }
}
