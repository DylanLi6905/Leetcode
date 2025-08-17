class Solution {
    Integer[][][] memo;
    int[] houses;
    int[][] cost;
    int m;
    int n;
    int target;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        memo = new Integer[m][n][target+1];
        return dp(0,0,0) != Integer.MAX_VALUE / 2 ? dp(0,0,0) : -1;
    }
    public int dp(int i, int color, int hoods){
        if(i == m){
            return hoods == target ? 0 : Integer.MAX_VALUE / 2;
        }
        if(memo[i][color][hoods] != null){
            return memo[i][color][hoods];
        }
        //Recurrence relation? 
        int res = Integer.MAX_VALUE / 2;
        if(houses[i] == 0){
            for(int j = 0; j < n; j++){
                int newHoods = (i == 0 || j != color) ? hoods + 1 : hoods;
                if (newHoods <= target) {
                    res = Math.min(res, cost[i][j] + dp(i + 1, j, newHoods));
                }
            }
        } else {
            int c = houses[i] - 1;
            int newHoods = (i == 0 || c != color) ? hoods + 1 : hoods;
            if (newHoods <= target) {
                res = Math.min(res, dp(i + 1, c, newHoods));
            }
        }
        return memo[i][color][hoods] = res;
    }
}