class Solution {
    String s;
    int[] memo;
    int n;
    int mod;
    public int numDecodings(String s) {
        this.s = s;
        n = s.length();
        memo = new int[s.length()];
        mod = 1_000_000_007;
        // '*' == 1 - 9 so 9 different chars
        Arrays.fill(memo, -1);
        //Return the number of ways to decode encoded message --
        return dp(0);
    }
    public int dp(int i){
        if(i == n){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        long ways = 0;
        char c = s.charAt(i);
        if(c == '*'){
            ways += 9L * dp(i + 1);
        } else {
            ways += dp(i + 1);
        }

        if(i + 1 < n){
            char c2 = s.charAt(i+1);
            if(c == '*' && c2 == '*'){
                ways += 15L * dp(i + 2);
            } else if(c == '*'){
                if(c2 >= '0' && c2 <= '6') ways += 2L * dp(i+2);
                else ways += dp(i+2);
            } else if(c2 == '*'){
                if(c == '1') ways += 9L * dp(i+2);
                else if(c == '2') ways += 6L * dp(i+2);
            } else {
                int val = (c - '0') * 10 + (c2 - '0');
                if(val >= 10 && val <= 26){
                    ways += dp(i+2);
                }
            }
        }

        return memo[i] = (int)(ways % mod);
        
    }
}