class Solution {
    private Integer[] memo;
    private String s;
    private int n;
    public int longestValidParentheses(String s) {
        this.n = s.length();
        this.s = s;
        memo = new Integer[n];
        int best = 0;
        for (int i = 0; i < n; i++) {
            best = Math.max(best, dp(i));
        }
        return best;
    }
    public int dp(int i){
        if (i < 0) {
            return 0;
        }
        if(memo[i] != null){
            return memo[i];
        }
        int res = 0;
        if (s.charAt(i) == ')') {
            if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                res = 2 + dp(i - 2);
            } else if (i - 1 >= 0 && s.charAt(i-1) == ')'){
                int prevIndex = i - dp(i - 1) - 1;
                if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
                    res = dp(i - 1) + 2 + dp(prevIndex - 1);
                }
            }

        }
        return memo[i] = res;
    }
}