class Solution {
    static final int MOD = 1_000_000_007;
    int[] memo;
    int high;
    int low;
    int zero;
    int one;
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.one = one;
        this.zero = zero;
        memo = new int[high+1];
        Arrays.fill(memo, -1);
        return dp(0);
    }
    public int dp(int i){
        if(i > high){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        //Recurrence is to take zero or one
        long count = 0;
        if (i >= low) {
            count++;
        }
        count = (count + dp(i + zero)) % MOD;
        count = (count + dp(i + one)) % MOD;

        return memo[i] = (int) count;
    }
}