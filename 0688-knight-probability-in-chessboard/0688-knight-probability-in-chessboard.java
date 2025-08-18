class Solution {
    int n; //L X W of board
    int k; // number of moves
    int row;
    int column;
    Double[][][] memo;
    int[][] dirs = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        //Probability knight makes k moves and remains on the board (after its stopped moving)
        this.n = n;
        this.k = k;
        this.row = row;
        this.column = column;
        memo = new Double[k+1][n][n];
        return dp(k, row, column);
    }
    public double dp(int k, int r, int c){
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0.0; // off-board
        }
        if (k == 0) {
            return 1.0;
        }
        if(memo[k][r][c] != null){
            return memo[k][r][c];
        }
        double total = 0.0;
        for(int[] d : dirs){
            total += dp(k - 1, r + d[0], c + d[1]);
        }
        return memo[k][r][c] = total / 8.0;
    }
}