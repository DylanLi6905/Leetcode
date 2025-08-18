class Solution {
    int MOD;
    String[] pizza;
    int k;
    int row;
    int col;
    Integer[][][] memo;
    int[][] prefix;
    public int ways(String[] pizza, int k) {
        MOD = 1_000_000_007;
        this.pizza = pizza;
        this.k = k;
        row = pizza.length;
        col = pizza[0].length();
        //Want to make k pieces using k-1 cuts 
        //Mathematically speaking every cut creates 2 pieces 
        prefix = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                prefix[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0);
                if (i > 0) prefix[i][j] += prefix[i-1][j];
                if (j > 0) prefix[i][j] += prefix[i][j-1];
                if (i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];
            }
        }
        memo = new Integer[k+1][row][col];
        return dp(k,0,0) ;
    }
    public int dp(int cuts, int r, int c){
        if(cuts == 1){
            return hasApple(r, c, row - 1, col - 1) ? 1 : 0; 
        }
        if(memo[cuts][r][c] != null){
            return memo[cuts][r][c];
        }
        long res = 0;
        for (int nr = r + 1; nr < row; nr++) {
            if (hasApple(r, c, nr - 1, col - 1)) {
                res = (res + dp(cuts - 1, nr, c)) % MOD;
            }
        }
        for(int nc = c + 1; nc < col; nc++){
            if(hasApple(r, c, row - 1, nc - 1)){
                res = (res + dp(cuts - 1, r, nc)) % MOD;
            }
        }
        return memo[cuts][r][c] = (int) res;
    }
    public boolean hasApple(int r1, int c1, int r2, int c2) {
        int total = prefix[r2][c2];
        if (r1 > 0) total -= prefix[r1 - 1][c2];
        if (c1 > 0) total -= prefix[r2][c1 - 1];
        if (r1 > 0 && c1 > 0) total += prefix[r1 - 1][c1 - 1];
        return total > 0;
    }
}