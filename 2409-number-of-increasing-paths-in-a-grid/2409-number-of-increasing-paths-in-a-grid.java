class Solution {
    int MOD;
    int[][] grid;
    int m;
    Integer[][] memo;
    int n;
    public int countPaths(int[][] grid) {
        //Return the number of strictly increasing cells
        MOD = 1_000_000_007;
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m+1][n+1];
        int output = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                output = (output + dp(i,j)) % MOD;
            }
        }
        return output;
    }
    public int dp(int r, int c){
        if (memo[r][c] != null) {
            return memo[r][c];
        }
        int res = 1; //If it is the only one
        if(isValid(r - 1, c) && grid[r][c] < grid[r-1][c]){
            res = (res + dp(r-1, c)) % MOD;
        }
        if(isValid(r + 1, c) && grid[r][c] < grid[r+1][c]){
            res = (res + dp(r+1, c)) % MOD;
        }
        if(isValid(r , c-1)&& grid[r][c] < grid[r][c-1]){
            res = (res + dp(r, c-1)) % MOD;
        }
        if(isValid(r, c + 1)&& grid[r][c] < grid[r][c+1]){
            res = (res + dp(r, c+1)) % MOD;
        }
        return memo[r][c] = res;
    }
    public boolean isValid(int r, int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}