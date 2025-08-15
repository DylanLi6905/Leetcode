class Solution {
    public int trap(int[] h) {
        int n = h.length, l = 0, r = n - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (l < r) {
            if (h[l] <= h[r]) {              // left side is the limiter
                if (h[l] >= leftMax) leftMax = h[l];
                else water += leftMax - h[l];
                l++;
            } else {                         // right side is the limiter
                if (h[r] >= rightMax) rightMax = h[r];
                else water += rightMax - h[r];
                r--;
            }
        }
        return water;
    }
}
