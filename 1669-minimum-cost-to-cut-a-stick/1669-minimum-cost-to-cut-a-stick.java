class Solution {
    Integer[][] memo; //Returns the smallest cost of all the cuts at of len n
    int[] a;
    int m;
    public int minCost(int n, int[] cuts) {
        //Return minimum cost of all cuts
        //n is 0 - n len
        //Cut cost is the len of the current stick
        Arrays.sort(cuts);
        m = cuts.length;
        a = new int[m + 2];
        a[0] = 0; a[m + 1] = n;
        for (int i = 0; i < m; i++) {
            a[i + 1] = cuts[i];
        }
        memo = new Integer[m + 2][m + 2];
        return dp(0, m + 1);
    }
    public int dp(int l, int r){
        if (r - l <= 1){
            return 0;
        }
        if(memo[l][r] != null){
            return memo[l][r];
        }
        //Recurrence 
        int best = Integer.MAX_VALUE;
        for(int k = l+1; k < r; k++){
            best = Math.min(best, a[r] - a[l] + dp(k, r) + dp(l, k));
        }
        return memo[l][r] = best;
    }
}