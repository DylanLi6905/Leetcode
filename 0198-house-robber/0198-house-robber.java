class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    int max;
    public int rob(int[] nums) {
        max = nums.length;
        return dynamicMax(max, nums);
    }
    public int dynamicMax(int i, int[] nums){
        if(i <= 0){
            return 0;
        }
        if(map.containsKey(i)) {
            return map.get(i);
        }
        //Note cant just pick the largest between first and second because if next to each other then police
        int result = Math.max(dynamicMax(i - 1, nums), dynamicMax(i - 2, nums) + nums[i - 1]);
        map.put(i, result);
        return result;
    }
}