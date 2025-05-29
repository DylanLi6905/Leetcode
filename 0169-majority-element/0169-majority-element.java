class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int number : nums){
            if(!map.containsKey(number)){
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        for(int num : map.keySet()){
            if(map.get(num) > Math.floor(nums.length / 2)){
                return num;
            }
        }
        return 0;
    }
}