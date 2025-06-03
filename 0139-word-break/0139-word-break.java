class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && set.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}