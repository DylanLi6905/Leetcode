class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dp(0, cost),dp(1,cost));
    }
    //Returns min cost num of steps
    public int dp(int i, int[] cost){
        if(i >= cost.length){
            return 0;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }
        int min = Math.min(dp(i+1, cost) + cost[i], dp(i+2,cost) + cost[i]);
        map.put(i, min);
        return map.get(i);
    }
}