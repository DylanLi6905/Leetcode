class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxSeen = 0;

        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);
            map.put(letter, right);
            if (map.size() > 2) {
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                left = delIndex + 1;
            }

            maxSeen = Math.max(maxSeen, right - left + 1);
        }

        return maxSeen;
    }
}