class Solution {
    int MOD;
    int[] locations;
    int start;
    int finish;
    int fuel;
    Integer[][] memo;
    int n;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        MOD = 1_000_000_007;
        //locations represents the pos of city
        //Given start finish and fuel
        //Return the count of all possible routes from start to finish
        this.locations = locations;
        this.start = start;
        this.finish = finish;
        this.fuel = fuel;
        n = locations.length;
        memo = new Integer[n][fuel+1];
        return dp(start, fuel);
    }
    public int dp(int i, int remain){
        if (remain < 0) {
            return 0;
        }
        if(memo[i][remain] != null){
            return memo[i][remain];
        }
        int res = (i == finish ? 1 : 0);
        for(int j = 0; j < n; j++){
            if(j == i){
                continue;
            }
            int diff = Math.abs(locations[j] - locations[i]);
            if (diff <= remain) {
                res = (res + dp(j, remain - diff)) % MOD;
            }
        }
        return memo[i][remain] = res;
    }
}