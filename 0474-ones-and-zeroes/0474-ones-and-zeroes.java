class Solution {
    private Integer[][][] memo;
    private String[] strs;
    private int m;
    private int n;
    private int len;
    public int findMaxForm(String[] strs, int m, int n) {
        //largest subset of strs s.t. at most m 0's and n 1's
        //Given? given 
        //1. list of binary strings
        //2. at most m 0's
        //3. at most n 1's
        len = strs.length;
        this.strs = strs;
        this.m = m;
        this.n = n;
        memo = new Integer[strs.length][m+1][n+1]; //memo intialized to all null
        return dp(0,0,0);
    }
    public int dp(int i, int zeros, int ones){
        if(i >= len){
            return 0;
        }
        if(memo[i][zeros][ones] != null){
            return memo[i][zeros][ones];
        }
        int res = dp(i+1, zeros, ones); //Skip 
        int countM = 0, countN = 0;
        for(char letter : strs[i].toCharArray()){
            if(letter == '0'){
                countM++;
            } else {
                countN++;
            }
        }
        if (zeros + countM <= m && ones + countN <= n) {
            res = Math.max(res, 1 + dp(i + 1, zeros + countM, ones + countN));
        }
        memo[i][zeros][ones] = res;
        return res;
    }
}