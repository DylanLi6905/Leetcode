class Solution {
    private int[][] memo;
    private int n;
    private int m;
    private int color;
    private int[][] costs;
    public int minCost(int[][] costs) {
        //red, blue, green
        //min cost of houses but no adjacent same colors
        this.costs = costs;
        n = costs.length;
        m = 4;
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 3);
    }
    public int dp(int i, int prev){
        if(i == n){
            return 0;
        }
        if(memo[i][prev] != -1){
            return memo[i][prev];
        }
        //Recurrence? choose min sum
        int min = Integer.MAX_VALUE;
        for(int color = 0; color < 3; color++){
            if(color != prev){
                int currCost = costs[i][color] + dp(i + 1, color);
                min = Math.min(min, currCost);
            }
        }
        memo[i][prev] = min;
        return min;
    }
}