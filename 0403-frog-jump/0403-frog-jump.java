class Solution {
    Boolean[][] memo;
    int[] stones;
    int n;
    public boolean canCross(int[] stones) {
        //last jump was k units
        //Next jump must be either k - 1, k, k+1
        //1, 0 1 2, -1 0 1 2 3, -2 -1 0 1 2 3 4, -3 -2 -1 0 1 2 3 4 5
        n = stones.length;
        this.stones = stones;
        memo = new Boolean[n][n+1];//index of jump and last jump length
        return dp(0,0);
    }
    public boolean dp(int i, int prev){
        if(i == n - 1){
            return true;
        }
        if(memo[i][prev] != null){
            return memo[i][prev];
        }
        //3 ranges
        for(int j = i+1; j < n; j++){
            int dist = stones[j] - stones[i];
            if(dist == prev - 1 || dist == prev || dist == prev + 1){
                if (dp(j, dist)) {
                    return memo[i][prev] = true;
                }
            }
            if (dist > prev + 1) break;
        }
        return memo[i][prev] = false;
    }
}