class Solution {
    int[] jobDifficulty;
    int d;
    Integer[][] memo;
    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;
        this.d = d;
        //At least 1 task a day
        //Diff of day is Math.max(day)
        //Minimum diff of job schedule
        memo = new Integer[jobDifficulty.length][d + 1];
        n = jobDifficulty.length;
        if(n < d){
            return -1;
        }
        return dp(0, 0);
    }
    public int dp(int job, int day){
        if (day == d) {
            int max = 0;
            for (int i = job; i < n; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }
        if(memo[job][day] != null){
            return memo[job][day];
        }
        int res = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = job; i <= n - (d - day); i++){
            curr = Math.max(curr, jobDifficulty[i]);
            res = Math.min(res, curr + dp(i + 1, day + 1));
        }
        return memo[job][day] = res;
    }
}