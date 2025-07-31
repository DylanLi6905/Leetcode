class Solution {
    private int[] memo;

    public int maxA(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    private int dp(int n) {
        if (n <= 0) return 0;
        if (memo[n] != -1) return memo[n];

        // Option 1: press A
        int max = dp(n - 1) + 1;

        // Option 2: do copy-paste starting from i
        // Try all breakpoints i where we build screen up to i,
        // then use 2 strokes for Ctrl-A and Ctrl-C, and the rest for Ctrl-V
        for (int i = 1; i <= n - 3; i++) {
            int copies = n - i - 2;
            int curr = dp(i) * (copies + 1); // paste copies+1 times
            max = Math.max(max, curr);
        }

        return memo[n] = max;
    }
}
