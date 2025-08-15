class Solution {
    int[] memo; //Represents the number of trees that can be formed with n nodes
    int n;
    public int numTrees(int n) {
        this.n = n;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        return dp(n);
    }
    public int dp(int i){
        if (memo[i] != -1){ 
            return memo[i];
        }
        int total = 0;
        for (int root = 1; root <= i; root++) {
            int left = dp(root - 1);
            int right = dp(i - root);
            total += left * right;
        }
        return memo[i] = total;
    }
}