class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);
        return;
    }
    public void reverse(char[] s, int left, int right){
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
    public void reverseEachWord(char[] s){
        int left = 0, right = 0;
        while(left < s.length){
            while (right < s.length && s[right] != ' ') ++right;
            reverse(s, left, right - 1);
            left = right + 1;
            ++right;
        }
    }
}