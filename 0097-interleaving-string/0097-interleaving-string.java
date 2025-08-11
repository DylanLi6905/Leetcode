class Solution {
    private Boolean[][] memo;
    private int n;
    private int m;
    private String s1, s2, s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        //State 
        //Base
        //Recurrence
        m = s1.length();
        n = s2.length();
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        if (m + n != s3.length()) return false;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dp(0,0);
    }
    public boolean dp(int i, int j){
        if (i == m && j == n){
            return true;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        boolean res = false;
        if(i < m && s1.charAt(i) == s3.charAt(i + j)){
            res = dp(i + 1, j);
        }
        if(!res && j < n && s2.charAt(j) == s3.charAt(i+j)){
            res = dp(i, j+1);
        }
        memo[i][j] = res;
        return res;
        //Recurrence relation
    }
}