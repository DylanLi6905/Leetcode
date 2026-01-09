class Solution {
    public int waysToSplitArray(int[] nums) {
        //0 Indexed int array of len n
        //Valid split at i if true 
        //1. sum of i + 1 elems >= sum of last n - i - 1 elems
        //2. At least oen elem to right of i 
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        //pre-processed
        int output = 0;
        for(int j = 0; j < nums.length - 1; j++){
            if(prefix[j] >= (prefix[nums.length-1] - prefix[j])){
                output++;
            }
        }
        return output;
    }
}