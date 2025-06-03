class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //Simple greedy algorithm
        PriorityQueue<Integer> profitHeap = new PriorityQueue<>((a,b) -> profits[b] - profits[a]);
        PriorityQueue<Integer> capitalHeap = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        for (int i = 0; i < capital.length; i++) {
            capitalHeap.add(i);
        }
        for(int j = 0; j < k; j++){
            while(!capitalHeap.isEmpty() && w >= capital[capitalHeap.peek()]){
                int idx = capitalHeap.poll();
                profitHeap.offer(idx);
            }
            if (profitHeap.isEmpty()) {
                break;
            }
            w += profits[profitHeap.poll()];
        }
        return w;
    }
}