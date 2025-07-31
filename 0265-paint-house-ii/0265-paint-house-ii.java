class Solution {
    private int[][] costs;
    private int[][] memo;
    private int n;
    private int m;

    public int minCostII(int[][] costs) {
        n = costs.length;
        m = costs[0].length;
        this.costs = costs;
        memo = new int[n][m + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(0, m);
    }
    public int dp(int index, int prev){
        if(index == n){
            return 0;
        }
        if(memo[index][prev] != -1){
            return memo[index][prev];
        }
        int min = Integer.MAX_VALUE;
        for(int color = 0; color < m; color++){
            if(prev != color){
                int curr = dp(index+1, color) + costs[index][color];
                min = Math.min(min, curr);
            }
        }
        memo[index][prev] = min;
        return min;
    }
}