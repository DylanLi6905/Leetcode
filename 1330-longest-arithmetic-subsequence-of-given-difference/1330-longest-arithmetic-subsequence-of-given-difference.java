class Solution {
    private int[] arr;
    private int difference;
    private int m;
    private int[] memo;
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int val : arr) {
            int prev = val - difference;
            int len = dp.getOrDefault(prev, 0) + 1;
            dp.put(val, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public int dp(int i){
        if(i >= m){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        //Recurrence relation? start new or continue old
        int best = 1;
        for (int j = i + 1; j < m; j++) {
            if (arr[j] == arr[i] + difference) {
                best = Math.max(best, 1 + dp(j));
                break; // break because difference is fixed, only one j possible
            }
        }
        memo[i] = best;
        return best;
    }
}