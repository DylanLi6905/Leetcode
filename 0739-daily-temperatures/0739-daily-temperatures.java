class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {int n = temperatures.length;
        int[] output = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                output[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return output;
    }
}