class Solution {
    Integer[][] memo;
    String s;
    public int longestPalindromeSubseq(String s) {
        this.s = s;
        memo = new Integer[s.length()][s.length()];
        return dp(0,s.length() - 1);
    }
    public int dp(int i, int j){
        if (i > j) return 0;
        if (i == j) return 1;
        if(memo[i][j] != null){
            return memo[i][j];
        }
        //Recurrence Take or skip
        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = 2 + dp(i + 1, j - 1);
        } else{
            memo[i][j] = Math.max(dp(i, j-1), dp(i+1, j));
        }
        return memo[i][j];
    }
}