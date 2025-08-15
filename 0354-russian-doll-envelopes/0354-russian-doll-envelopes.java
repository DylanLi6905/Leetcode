import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: sort by width asc, height desc if widths equal
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        // Step 2: extract heights
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Step 3: LIS on heights (O(n log n))
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int idx = Arrays.binarySearch(sub, 0, len, num);
            if (idx < 0) idx = -(idx + 1); // insertion point
            sub[idx] = num;
            if (idx == len) len++;
        }
        return len;
    }
}
