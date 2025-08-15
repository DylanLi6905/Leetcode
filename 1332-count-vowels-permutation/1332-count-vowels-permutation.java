class Solution {
    int[][] arr;
    int[][] memo;
    int n;
    static final int MOD = 1_000_000_007;
    public int countVowelPermutation(int n) {
        //Count how many strings of len n can be formed
        //State? 
        this.n = n;
        arr = new int[][] {
            {1},        // a -> e
            {0, 2},     // e -> a, i
            {0, 1, 3, 4}, // i -> a, e, o, u
            {2, 4},     // o -> i, u
            {0}         // u -> a
        };
        memo = new int[n][5];
        //1. a must be followed by an e
        //2. e followed by a or i
        //3. i cannot be followed by another i
        //4. o can be followed by i or u
        //5. u can followed by an a
        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }
        int total = 0;
        for (int v = 0; v < 5; v++) {
            total = (total + dp(0, v)) % MOD;
        }
        return total;
    }
    public int dp(int i, int prev){
        if (i == n - 1) return 1;
        if(memo[i][prev] != -1){
            return memo[i][prev];
        }
        //Recurrence?
        int count = 0;
        for(int next : arr[prev]){
            count = (count + dp(i + 1, next)) % MOD;
        }
        return memo[i][prev] = (int)(count);

    }
}