class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);  // Sort first to enable two-pointer and duplicate skipping
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate fixed values
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int fixed = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int total = fixed + nums[left] + nums[right];
                
                if (total == 0) {
                    output.add(Arrays.asList(fixed, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                }
                else if (total < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        
        return output;
    }
}
