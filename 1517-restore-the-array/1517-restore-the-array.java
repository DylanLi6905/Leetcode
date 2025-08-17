class Solution {
    static final int MOD = 1_000_000_007;
    String s;
    int k;
    int[] memo;
    int n;
    public int numberOfArrays(String s, int k) {
        this.s = s;
        this.k = k;
        //Base case?
        //State?
        //Recurrence
        memo = new int[s.length()]; //index will represent the places I can put ','
        n = s.length();
        Arrays.fill(memo, -1);
        return dp(0);
    }
    public int dp(int i){
        if(i == n){
            return 1;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        if(s.charAt(i) == '0'){  // leading zero case
            return memo[i] = 0;
        }
        //Recurrence
        int res = 0;
        for(int j = i; j < n; j++){ //Build substrings from i to j
            long val = Long.parseLong(s.substring(i, j+1));
            if(val > k){
                break;
            }
            res = (res + dp(j+1)) % MOD; 
        }
        return memo[i] = res;
    }
}