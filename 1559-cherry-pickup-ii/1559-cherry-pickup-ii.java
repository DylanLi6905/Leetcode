class Solution {
    Integer[][][] memo;
    int[][] grid;
    int row;
    int col;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        memo = new Integer[row][col][col];
        return dp(0, 0, col - 1);
    }
    public int dp(int r, int c1, int c2){
        if(r == row){
            return 0;
        }
        if(memo[r][c1][c2] != null){
            return memo[r][c1][c2];
        }
        int cherries = grid[r][c1];
        if (c1 != c2) { 
            cherries += grid[r][c2];
        }
        int res = Integer.MIN_VALUE;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                int nc1 = c1 + i;
                int nc2 = c2 + j;
                if (nc1 >= 0 && nc1 < col && nc2 >= 0 && nc2 < col) {
                    res = Math.max(res, dp(r + 1, nc1, nc2));
                }
            }
        }
        return memo[r][c1][c2] = res + cherries;

    }
}