class Solution {
    private int[] memo;
    public int fib(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(n);
    }
    public int dp(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(memo[n] != -1){
            return memo[n];
        }
        memo[n] = dp(n-1) + dp(n-2);
        return memo[n];
    }
}