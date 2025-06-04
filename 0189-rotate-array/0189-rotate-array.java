class Solution {
    public void rotate(int[] nums, int k) {
        //Rotate the array to the right by k steps
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            output[(i+k) % nums.length] = nums[i]; 
        }
        for(int j = 0; j< nums.length; j++){
            nums[j] = output[j];
        }
    }
}