class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int longest = 0;
        ArrayDeque<Integer> decreasing = new ArrayDeque<>();
        ArrayDeque<Integer> increasing = new ArrayDeque<>();
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            while(!decreasing.isEmpty() && decreasing.getLast() < nums[right]){
                decreasing.removeLast();
            }
            while(!increasing.isEmpty() && increasing.getLast() > nums[right]){
                increasing.removeLast();
            }
            increasing.addLast(nums[right]);
            decreasing.addLast(nums[right]);
            //Increasing is strictly increasing meaning largest is at end
            //Decreasing is strictly decreasing meaning smallest is at end
            while(decreasing.getFirst() - increasing.getFirst() > limit){
                if (nums[left] == decreasing.getFirst()) {
                    decreasing.removeFirst();
                }
                if (nums[left] == increasing.getFirst()) {
                    increasing.removeFirst();
                }
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}