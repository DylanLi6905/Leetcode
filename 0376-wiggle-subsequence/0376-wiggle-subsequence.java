class Solution {
    int[][] memo;
    int[] nums;
    int n;
    int longest; 
    public int wiggleMaxLength(int[] nums) {
        this.nums = nums;
        n = nums.length;
        memo = new int[n][2];
        longest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return Math.max(dp(0, 0), dp(0, 1));
    }
    public int dp(int i, int dir){
        if(memo[i][dir] != -1){
            return memo[i][dir];
        }
        //Recurrence is to start seq from here or if increasing
        int best = 1;
        for(int j = i + 1; j < n; j++){
            if (dir == 0 && nums[j] > nums[i]) {
                best = Math.max(best, 1 + dp(j, 1));
            }
            if(dir == 1 && nums[j] < nums[i]) {
                best = Math.max(best, 1 + dp(j, 0));
            }
        }
        return memo[i][dir] = best;
        
    }
}