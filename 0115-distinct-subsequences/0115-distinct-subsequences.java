class Solution {
    Integer[][] memo;
    String s;
    String t;
    int m;
    int n;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        m = s.length();
        n = t.length();
        memo = new Integer[m][n];
        return dp(0, 0);
    }
    public int dp(int i, int j){
        if(j == n){
            return 1;
        }
        if(i == m){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }
        //Recurrence? 
        int count = 0;
        if(t.charAt(j) == s.charAt(i)){
            count += dp(i + 1, j + 1) + dp(i + 1, j);  
        } else {
            count += dp(i + 1, j);
        }
        return memo[i][j] = count;
    }
}