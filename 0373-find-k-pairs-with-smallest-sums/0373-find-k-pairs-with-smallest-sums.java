class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //Two lists sorted in non-decreasing order
        //output is looking for k number of pairs
        //Pairs consist of one element from first array and one from second (of the smallest sums)
        List<List<Integer>> output = new ArrayList<>();
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        int limit = Math.min(nums1.length, k);
        
        for (int i = 0; i < limit; i++) {
            minHeap.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        for(int l = 0; l < k && !minHeap.isEmpty(); l++){
            List<Integer> top = minHeap.poll();
            int val1 = top.get(0);
            int val2 = top.get(1);
            int idx2 = top.get(2);

            // Add just the pair [val1, val2] to output
            output.add(Arrays.asList(val1, val2));

            // 3) If there is a next element in nums2, push (val1, nums2[idx2+1], idx2+1)
            if (idx2 + 1 < nums2.length) {
                minHeap.offer(Arrays.asList(val1, nums2[idx2 + 1], idx2 + 1));
            }
        }
        return output;
    }
}