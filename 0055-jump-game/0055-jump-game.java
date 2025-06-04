class Solution {
    public boolean canJump(int[] nums) {
        int[] seen = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                seen[0] = 1;
            }
            for(int j = 1; j <= nums[i]; j++){
                if (seen[i] == 0) continue;
                if(j+i < nums.length && seen[j+i] == 0){
                    seen[j+i] = 1;
                }
            }
        }
        return seen[nums.length-1] == 1;
    }


}