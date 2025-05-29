class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int number : prices){
            minPrice = Math.min(minPrice, number);
            maxProfit = Math.max(maxProfit, number - minPrice);
        }
        return maxProfit;
    }
}
