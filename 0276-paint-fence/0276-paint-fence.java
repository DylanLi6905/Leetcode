class Solution {
    private int[] memo;
    private int k;

    public int numWays(int n, int k) {
        this.k = k;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    private int dp(int n) {
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k * k;
        if (memo[n] != -1) return memo[n];
        return memo[n] = (dp(n - 1) + dp(n - 2)) * (k - 1);
    }
}
