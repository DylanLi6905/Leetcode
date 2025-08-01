class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] arr = expression.toCharArray();
        for(int i = arr.length - 1; i >= 0; i--){
            if(!stack.isEmpty() && stack.peek() == '?'){
                stack.pop(); //?
                char t = stack.pop();
                stack.pop(); // :
                char f = stack.pop(); 
                if(arr[i] == 'T'){
                    stack.push(t);
                } else {
                    stack.push(f);
                }
            } else {
                stack.push(arr[i]);
            }
        }
        return stack.peek().toString();
    }
}