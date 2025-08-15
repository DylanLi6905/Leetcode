class Solution {
    int low;
    int high;
    String s;
    int[] memo;
    int n;
    public int numDecodings(String s) {
        low = 1;
        high = 26;
        this.s = s;
        memo = new int[s.length()];
        n = s.length();
        Arrays.fill(memo, -1);
        return dp(0);
    }
    public int dp(int i){
        if(i == n){
            return 1;
        }
        if (s.charAt(i) == '0') return 0;
        if(memo[i] != -1){
            return memo[i];
        }
        int ways = dp(i + 1); 
        if (i + 1 < n) {
            int val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (val >= 10 && val <= 26) {
                ways += dp(i + 2);
            }
        }
        return memo[i]= ways;
    }
}