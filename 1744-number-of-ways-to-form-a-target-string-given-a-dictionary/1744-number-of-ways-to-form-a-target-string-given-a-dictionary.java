class Solution {
    int MOD;
    String[] words;
    String target;
    Integer[][] memo;
    int m;
    int n;
    int[][] count;
    public int numWays(String[] words, String target) {
        MOD = 1_000_000_007;
        //formed left to right
        //ith of target choose kth of jth string target[i] = words[j][k]
        //Can no longer use the xth char where x <= k
        
        //Len of all words given are the same
        //Need i index of target and j index of word
        this.words = words;
        this.target = target;
        m = words[0].length();
        n = target.length();
        count = new int[m][26];
        for (String word : words) {
            for (int j = 0; j < m; j++) {
                count[j][word.charAt(j) - 'a']++;
            }
        }
            memo = new Integer[n][m+1];
            return dp(0,0);
        }
    public int dp(int i, int j){
        if(i == n){
            return 1;
        }
        if (j == m) return 0; 
        if(memo[i][j] != null){
            return memo[i][j];
        }
        long res = dp(i, j+1);
        int c = target.charAt(i) - 'a';
        if (count[j][c] > 0) {
            res += (long) count[j][c] * dp(i+1, j+1);
        }
        return memo[i][j] = (int) (res % MOD);
    }
}