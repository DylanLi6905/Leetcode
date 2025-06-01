class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return output;
        }
        backtrack("", output, phone_map, digits);
        return output;
    }
    public void backtrack(String curr, List<String> output, String[] phone_map, String digits){
        if(curr.length() == digits.length()){
            output.add(curr);
            return;
        }
        int digitIndex = digits.charAt(curr.length()) - '2';
        String letters = phone_map[digitIndex];
        for (char letter : letters.toCharArray()) {
            backtrack(curr + letter, output, phone_map, digits);
        }
    }
}