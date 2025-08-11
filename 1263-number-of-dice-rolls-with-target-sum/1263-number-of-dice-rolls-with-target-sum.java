class Solution {
    private int[][] memo;
    private int n;
    private int k;
    private int target;
    private static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        this.target = target;
        memo = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0);
    }
    public int dp(int i, int sum){
        if(i == n){
            return sum == target ? 1 : 0;
        }
        if(memo[i][sum] != -1){
            return memo[i][sum];
        }
        long ways = 0;
        for(int face = 1; face <= k; face++){
            if (sum + face <= target) {
                ways += dp(i + 1, sum + face);
                ways %= MOD;
            }
        }
        return memo[i][sum] = (int) ways;
    }
}