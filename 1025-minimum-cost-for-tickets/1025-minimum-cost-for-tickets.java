class Solution {
    int[] days;
    int[] costs;
    int[] memo;
    int n;
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        this.days = days;
        this.costs = costs;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(0);
    }
    public int dp(int i){
        if(i >= n){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        //Recurrence is to either buy 1 day 7 day or 30 day pass
        
        int j = i;
        while (j < n && days[j] < days[i] + 1) j++;
        int cost1 = costs[0] + dp(j);

        // 7-day pass
        j = i;
        while (j < n && days[j] < days[i] + 7) j++;
        int cost7 = costs[1] + dp(j);

        // 30-day pass
        j = i;
        while (j < n && days[j] < days[i] + 30) j++;
        int cost30 = costs[2] + dp(j);

        return memo[i] = Math.min(cost1, Math.min(cost7, cost30));
        
    }
}