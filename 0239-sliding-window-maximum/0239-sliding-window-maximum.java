class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.getFirst() + k == i) {
                queue.removeFirst();
            }
            if(i >= k - 1){
                output[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return output;
    }
}