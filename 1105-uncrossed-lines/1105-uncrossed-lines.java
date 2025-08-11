class Solution {
    private int[][] memo;
    private int m;
    private int n;
    private int[] nums1;
    private int[] nums2;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(0,0);
        
    }
    public int dp(int i, int j){
        if(i >= m || j >= n){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        //Recurrence relation
        if (nums1[i] == nums2[j]) {
            memo[i][j] = 1 + dp(i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(dp(i+1, j),dp(i, j+1));
        }
        return memo[i][j];
    }

}