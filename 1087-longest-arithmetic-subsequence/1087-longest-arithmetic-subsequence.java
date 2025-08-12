class Solution {
    private int[] nums;
    private int[][] memo;
    private int n;
    private int offset = 500;
    public int longestArithSeqLength(int[] nums) {
        this.n = nums.length;
        //Longest arithmetic subsequence
        //What do i need to know in order to build subproblems leading to result? (the longest until the index nums len)
        this.nums = nums;
        int offset = 500;
        int maxDiff = 1001;
        memo = new int[n][maxDiff];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i] + offset;
                result = Math.max(result, 2 + dp(j, diff));
            }
        }
        return result;
    }
    public int dp(int i, int diff){
        if (memo[i][diff] != -1) {
            return memo[i][diff];
        }

        int best = 0;
        for (int k = i + 1; k < n; k++) {
            if (nums[k] - nums[i] + offset == diff) {
                best = Math.max(best, 1 + dp(k, diff));
            }
        }

        return memo[i][diff] = best;
    }

}