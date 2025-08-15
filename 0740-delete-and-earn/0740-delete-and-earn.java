class Solution {
    Map<Integer, Integer> points = new HashMap<>();
    Map<Integer, Integer> memo = new HashMap<>();
    int maxVal = 0;
    public int deleteAndEarn(int[] nums) {
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxVal = Math.max(maxVal, num);
        }
        return dp(1);
    }
    public int dp(int val){
        if (val > maxVal) {
            return 0;
        }
        if (memo.containsKey(val)) {
            return memo.get(val);
        }
        int take = points.getOrDefault(val, 0) + dp(val + 2);
        int skip = dp(val + 1);
        int res = Math.max(take, skip);
        memo.put(val, res);
        return res;
    }
}