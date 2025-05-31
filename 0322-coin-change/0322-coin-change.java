class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result = dp(amount, coins);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    //DP is used to determine the transition between recurrence relations
    //Return the min number of coins to make
    public int dp(int amount, int[] coins){
        //Base case
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        if(map.containsKey(amount)){
            return map.get(amount);
        }
        //Recurrence
        int base = Integer.MAX_VALUE;
        for(int coin : coins){
            int temp = dp(amount - coin, coins);
            if(temp != Integer.MAX_VALUE){
                base = Math.min(base, temp+1);
            }
        }
        map.put(amount, base);
        return map.get(amount);
    }
}