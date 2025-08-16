class Solution {
    int[] memo;
    int n;
    public int numSquares(int n) {
        this.n = n;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(n);
    }
    public int dp(int i){
        if (i == 0){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        int min = Integer.MAX_VALUE;
        int sq = 1;
        while (sq * sq <= i) {
            min = Math.min(min, 1 + dp(i - sq * sq));
            sq++;
        }
        return memo[i] = min;
    }
}