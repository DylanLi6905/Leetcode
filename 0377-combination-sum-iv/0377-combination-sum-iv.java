class Solution {
    int[] memo;
    int[] nums;
    int target;
    int n;
    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        n = nums.length;
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dp(target);
    }
    public int dp(int i){
        if (i == 0) {
            return 1;   
        }
        if (i < 0){
            return 0; 
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int count = 0;
        for(int num : nums){
            count += dp(i - num); 
        }
        return memo[i] = count;
    }
}