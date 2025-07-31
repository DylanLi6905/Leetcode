class Solution {
    private int[][] memo;
    private int n;
    private int m;
    private char[][] matrix;
    private int maxSide = 0;
    public int maximalSquare(char[][] matrix) {
        //State
        //Recurrence
        //Base
        this.matrix = matrix;
        n = matrix.length;
        m = matrix[0].length;
        memo = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp(i, j);
            }
        }
        return maxSide * maxSide;
    }
    public int dp(int row, int col){
        if (row >= n || col >= m) {
            return 0;
        }
        if(memo[row][col] != -1){
            return memo[row][col];
        }
        int down = dp(row + 1, col);
        int right = dp(row, col + 1);
        int diag = dp(row + 1, col + 1);
        if (matrix[row][col] == '1') {
            memo[row][col] = 1 + Math.min(down, Math.min(right, diag));
            maxSide = Math.max(maxSide, memo[row][col]);
        } else {
            memo[row][col] = 0;
        }
        return memo[row][col];
    }
}