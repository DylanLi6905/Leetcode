class Solution {
    private Integer[] memo;
    private int[] nums;
    private int n;
    public int maxProduct(int[] nums) {
        n = nums.length;
        this.nums = nums;
        memo = new Integer[n];
         int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {  // check every starting point
            ans = Math.max(ans, dp(i));
        }
        return ans;
    }
    public int dp(int i){
        if(i >= n){
            return 0;
        }
        if(memo[i] != null){
            return memo[i];
        }
        int res = nums[i];
        int prod = nums[i];
        for(int j = i + 1; j < n; j++){
            prod *= nums[j];
            res = Math.max(res, prod);
        }
        memo[i] = res;
        return res;
    }
}