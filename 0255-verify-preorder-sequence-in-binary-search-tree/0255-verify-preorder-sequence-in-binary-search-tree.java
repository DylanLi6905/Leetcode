class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE; 
        stack.push(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] < lowerBound) {
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                lowerBound = stack.pop();
            }
            stack.push(preorder[i]);
        }

        return true;
    }
}
