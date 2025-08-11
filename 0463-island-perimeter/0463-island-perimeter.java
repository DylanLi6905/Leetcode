class Solution {
    private int[][] grid;
    private int[][] seen;
    private int n;
    private int m;
    private int output;
    public int islandPerimeter(int[][] grid) {

        n = grid.length;
        m = grid[0].length;
        seen = new int[n][m];
        output = 0;
        this.grid = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && seen[i][j] != 1) {
                    dfs(i, j);
                }
            }
        }
        return output;
    }
    public void dfs(int row, int col){
        seen[row][col] = 1;
        if(isValid(row - 1, col) && seen[row-1][col] != 1){
            dfs(row - 1 , col);
        } else if (!isValid(row - 1, col)) {
            output++;
        }
        if(isValid(row + 1, col)&& seen[row+1][col] != 1){
            dfs(row + 1, col);
        } else if (!isValid(row + 1, col)) {
            output++;
        }
        if(isValid(row, col -1)&& seen[row][col-1] != 1){
            dfs(row, col - 1);
        } else if (!isValid(row, col - 1)) {
            output++;
        }
        if(isValid(row, col + 1)&& seen[row][col+1] != 1){
            dfs(row, col + 1);
        }else if (!isValid(row, col + 1)) {
            output++;
        }
        return;
    }
    public boolean isValid(int row, int col){
        if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
            return true;
        }
        return false;
    }
}