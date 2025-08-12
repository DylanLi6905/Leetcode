class Solution {
    private int[] stoneValue;
    private int len;
    private Integer[] memo;
    public String stoneGameIII(int[] stoneValue) {
        //Givens
        //Stone piles (can only take the from the first remaining stones in the row 1 - 3)
        //Player score is the sum of the values taken (Alice first Bob next)
        //What do i need to determine who wins? 
        //At each state you can take rock 1, 1 2, or 1 2 3. (index of stones, max current sum)
        this.stoneValue = stoneValue;
        len = stoneValue.length;
        memo = new Integer[len];
        int temp = dp(0);
        if(temp < 0){
            return "Bob";
        } else if (temp == 0){
            return "Tie";
        } else {
            return "Alice";
        }
    }
    public int dp(int i) {
        if (i == len) return 0;
        if (memo[i] != null) return memo[i];

        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int x = 0; x < 3 && i + x < len; x++) {
            sum += stoneValue[i + x];
            // Current player gains sum, opponent’s turn subtracts their best
            best = Math.max(best, sum - dp(i + x + 1));
        }
        return memo[i] = best;
    }
}