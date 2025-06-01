class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] output = new int[2];
        while(left < right){
            int total = numbers[left] + numbers[right];
            if(total == target){
                output[0] = left+1;
                output[1] = right+1;
                return output;
            } else if (total > target) {
                right--;
            } else {
                left++;
            }
        }
        return output;
    }
}