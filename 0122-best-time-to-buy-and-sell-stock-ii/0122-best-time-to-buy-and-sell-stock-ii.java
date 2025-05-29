class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < smallest){
                smallest = prices[i];
            } else {
                max += prices[i] - smallest;
                smallest = prices[i];
            }
        }
        return max;
    }
}