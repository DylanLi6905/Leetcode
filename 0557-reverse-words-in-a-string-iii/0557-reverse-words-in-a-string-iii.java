class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder output = new StringBuilder();
        for(String word : arr){
            int left = 0, right = word.length() - 1;
            char[] w = word.toCharArray();
            while(left < right){
                char temp = w[left];
                w[left] = w[right];
                w[right] = temp;
                left++;
                right--;
            }
            output.append(String.valueOf(w));
            output.append(" ");
        }
        return output.toString().trim();
    }
}