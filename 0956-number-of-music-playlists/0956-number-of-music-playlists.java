class Solution {
    int MOD;
    int n;
    int goal;
    int k;
    Integer[][] memo;
    public int numMusicPlaylists(int n, int goal, int k) {
        MOD = 1_000_000_007;
        this.n = n;
        this.goal = goal;
        this.k = k;
        memo = new Integer[goal + 1][n + 1];
        return dp(0,0);
    }
    public int dp(int len, int used){
        if (len == goal) {
            return used == n ? 1 : 0;
        }
        if(memo[len][used] != null){
            return memo[len][used];
        }
        //Recurrence to take song
        long res = 0;
        if (used < n) {
            res += (long)(n - used) * dp(len+1, used+1);
        }
        if (used > k){
            res += (long)(used - k) * dp(len + 1, used);
        }
        return memo[len][used] = (int)(res % MOD);

    }
}