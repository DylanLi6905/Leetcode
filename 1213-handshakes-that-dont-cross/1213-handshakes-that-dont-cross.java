class Solution {
    int MOD;
    int numPeople;
    int[] memo;
    public int numberOfWays(int numPeople) {
        //Even numPeople standing in a circle n/2 handshakes total
        MOD = 1_000_000_007;
        memo = new int[numPeople+1];
        this.numPeople = numPeople;
        Arrays.fill(memo, -1);
        return dp(numPeople);
    }
    public int dp(int i){
        if (i == 0) return 1;
        if (i == 2) return 1;
        if (memo[i] != -1) {
            return memo[i];
        }
        long res = 0;
        for(int j = 2; j <= i; j += 2){
            res += (long) dp(j - 2) * dp(i - j);
            res %= MOD;
        }
        return memo[i] = (int) res;
    }
}