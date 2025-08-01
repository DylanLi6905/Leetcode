class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length() ; right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(map.size() > k){ //If more distinct than k
                char letter = s.charAt(left);
                map.put(letter, map.get(letter) - 1);
                if(map.get(letter) == 0){
                    map.remove(letter);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}