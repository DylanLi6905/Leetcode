class Solution {
    private int[][] memo;
    private int[] coins;
    private int amount;
    private int m;
    public int change(int amount, int[] coins) {
        this.amount = amount;
        this.coins = coins;
        m = coins.length;
        memo = new int[m][amount+1];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0);
    }
    public int dp(int i, int curr){
        if(curr == amount){
            return 1;
        }
        if(curr > amount){
            return 0;
        }
        if(i >= m){
            return 0;
        }
        if(memo[i][curr] != -1){
            return memo[i][curr];
        }
        int take = dp(i, curr + coins[i]);
        int skip = dp(i + 1, curr);
        return memo[i][curr] = take + skip;
        
    }
}