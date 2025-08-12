class Solution {
    private int[] memo;
    private int[] nums;
    private int[] prev;
    private int n;
    private int maxLen;
    private int maxIndex;
    public List<Integer> largestDivisibleSubset(int[] nums) {
         //distinct pos int nums, LARGEST subset s.t every pair % == 0
         Arrays.sort(nums);
         n = nums.length;
         this.nums = nums;
         this.prev = new int[n];
         memo = new int[n];
         Arrays.fill(memo, -1);
         Arrays.fill(prev, -1);
        int temp = dp(0);
        for (int i = 0; i < n; i++) {
            dp(i);
        }

        // Reconstruct the subset
        List<Integer> output = new ArrayList<>();
        int curr = maxIndex;
        while (curr != -1) {
            output.add(nums[curr]);
            curr = prev[curr];
        }

        return output;
    }
    public int dp(int i){
        if (i == n) {
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        //Recurrence relation
        memo[i] = 1; //If start of new
        for (int j = i + 1; j < n; j++) {
            if (nums[j] % nums[i] == 0) {
                int candidate = 1 + dp(j);
                if (candidate > memo[i]) {
                    memo[i] = candidate;
                    prev[i] = j;
                }
            }
        }
        if(memo[i] > maxLen){
            maxLen = memo[i];
            maxIndex = i;
        }
        return memo[i];
    }
}