class Solution {
    private int[][] seen;
    private int[][] grid;
    private int n;
    private int m;
    private int output;
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        output = 0;
        seen = new int[n][m];
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isBorder(i, j) && seen[i][j] != 1) {
                    dfs(i, j);
                }
            }
        }

        // Step 2: Count remaining unvisited land
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && seen[i][j] != 1) {
                    output++;
                }
            }
        }
        return output;
    }
    public void dfs(int row, int col){
        seen[row][col] = 1;
        if(isValid(row - 1, col) && seen[row - 1][col] != 1){
            dfs(row-1, col);
        }
        if(isValid(row + 1, col) && seen[row + 1][col] != 1){
            dfs(row+1, col);
        }
        if(isValid(row, col-1) && seen[row][col-1] != 1){
            dfs(row, col-1);
        }
        if(isValid(row, col+1) && seen[row][col+1] != 1){
            dfs(row, col+1);
        }
        return;
    }
    public boolean isBorder(int row, int col) {
        return grid[row][col] == 1 && (row == 0 || row == n - 1 || col == 0 || col == m - 1);
    }
    public boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1;
    }
}