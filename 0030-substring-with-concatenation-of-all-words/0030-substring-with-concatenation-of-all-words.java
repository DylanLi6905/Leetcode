class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return output;

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        if (s.length() < totalLen) return output;

        // Build frequency map for words[]
        Map<String,Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // Slide over s with a window of size totalLen, advancing in steps of wordLen
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset;
            Map<String,Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;

                if (!freq.containsKey(w)) {
                    // Reset window if w is not even in words[]
                    seen.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                // Add w into seen
                seen.put(w, seen.getOrDefault(w, 0) + 1);
                count++;

                // If w appears too many times, shrink from left until it's valid again
                while (seen.get(w) > freq.get(w)) {
                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }

                // If we've matched exactly numWords consecutive words, record left
                if (count == numWords) {
                    output.add(left);
                    // Move left one word forward to look for next possible start
                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }
            }
        }

        return output;
    }
}
