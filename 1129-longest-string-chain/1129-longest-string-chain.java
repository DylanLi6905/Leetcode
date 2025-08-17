class Solution {
    String[] words;
    int[] memo;
    int n;
    public int longestStrChain(String[] words) {
        //prececessor iff insert one letter anywhere in wordA without changing order of other characters to == wordb
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        this.words = words;
        //Base case a single word is word chain k == 1
        //State - what do i need to recursively build up the subproblem?
        this.n = words.length;
        this.memo = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp(i));
        }
        return ans;
    }
    public int dp(int i){
        if (memo[i] != 0) return memo[i];

    int best = 1; // at least the word itself
    for (int j = i + 1; j < n; j++) {
        if (isPredecessor(words[i], words[j])) {
            best = Math.max(best, 1 + dp(j));
        }
    }
    return memo[i] = best;
    }
    private boolean isPredecessor(String a, String b) {
    if (b.length() != a.length() + 1) return false;
    int i = 0, j = 0;
    while (i < a.length() && j < b.length()) {
        if (a.charAt(i) == b.charAt(j)) {
            i++; j++;
        } else {
            j++; // skip one char in b
            if (j - i > 1) return false;
        }
    }
    return true;
}
}