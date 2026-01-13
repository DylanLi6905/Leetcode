class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            output[i] = -1;
        }
        for(int j = 0; j < nums2.length; j++){
            while(!stack.isEmpty() && nums2[j] > nums2[stack.peek()]){
                int temp = stack.pop();
                output[temp] = nums2[j];
            }
            stack.push(j);
        }
        for(int k = 0; k < nums1.length; k++){
          int temp = 0;
            while(nums2[temp] != nums1[k]){
                temp++;
            }
            nums1[k] = output[temp];
        }
        return nums1;
    }
}