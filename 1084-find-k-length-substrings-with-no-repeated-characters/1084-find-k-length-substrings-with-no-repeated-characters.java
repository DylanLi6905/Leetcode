class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int output = 0, left = 0, right = 0;
        while(right < s.length()){
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while (map.get(curr) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            while (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            if (right - left + 1 == k) {
                output++;
            }

            right++;
        }
        return output;
    }
}