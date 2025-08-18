class Solution {
    String s1;
    String s2;
    int m;
    Boolean[][][] memo;
    public boolean isScramble(String s1, String s2) {
        //Scrable s to get t using 
        //1. If len is 1, stop
        //2. if > 1 split string into two non empty substring random s, divide to x and y
        //3. randomly swap the two substrings or keep them in the same order
        //4. recursively step 1 on x and y
        this.s1 = s1;
        this.s2 = s2;
        m = s1.length();
        memo = new Boolean[m][m][m+1];
        return dp(0, 0, m);
    }
    public boolean dp(int i, int j, int len){
        if(memo[i][j][len] != null){
            return memo[i][j][len];
        }
        if (len == 1) { //Base case if len == 1 then stop
            return memo[i][j][len] = (s1.charAt(i) == s2.charAt(j));
        }
        //Check to make sure that in the substring that there is same number of each char
        int[] count = new int[26];
        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }
        for (int v : count) {
            if (v != 0) {
                return memo[i][j][len] = false;
            }
        }
        //Divide at each possible substring
        for(int split = 1; split < len; split++){
            //Swap 
            if(dp(i, j, split) && dp(i + split, j + split, len - split)){
                return memo[i][j][len] = true;
            }
            //No swap
            if (dp(i, j + len - split, split) && dp(i + split, j, len - split)) {
                return memo[i][j][len] = true;
            }
        }
        return memo[i][j][len] = false;

    }
}