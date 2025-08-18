class Solution {
    double[] prob;
    int target;
    int n;
    Double[][] memo;
    public double probabilityOfHeads(double[] prob, int target) {
        this.prob = prob;
        this.target = target;
        //Return probability of # coins is heads == target if every coin is tossed once
        n = prob.length;
        memo = new Double[n+1][target+1];
        return dp(0, 0);
    }
    public double dp(int i, int t){
        if (t > target) return 0.0;
        if (i == n) return t == target ? 1.0 : 0.0;
        if(memo[i][t] != null){
            return memo[i][t];
        }
        double tails = (1.0 - prob[i]) * dp(i + 1, t);
        double heads = prob[i] * dp(i + 1, t + 1);

        return memo[i][t] = tails + heads;
    }
}