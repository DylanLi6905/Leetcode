class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Arrays.sort(nums);
        int output = 0;
        int largest = Integer.MIN_VALUE;
        int deleted = 0;
        for(int num : nums){
            if(num >= 0 && !seen.contains(num)){
                output += num;
                largest = Math.max(largest, num);
                seen.add(num);
            } else {
                deleted++;
                largest = Math.max(largest, num);
            }
        }
        if(deleted == nums.length){
            return largest;
        } else {
            return output;
        }
    }
}