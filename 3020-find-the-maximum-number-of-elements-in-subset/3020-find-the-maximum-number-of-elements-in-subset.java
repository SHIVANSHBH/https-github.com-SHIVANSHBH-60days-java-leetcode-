import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special handling for 1:
        // Sequence looks like [1, 1, 1, ... , 1]
        // Valid length must be odd.
        if (freq.containsKey(1L)) {
            int ones = freq.get(1L);
            ans = Math.max(ans, (ones % 2 == 1) ? ones : ones - 1);
        }

        for (long x : freq.keySet()) {
            if (x == 1L) continue;

            long curr = x;
            int len = 0;

            while (freq.getOrDefault(curr, 0) >= 2) {
                len += 2;
                if (curr > 1000000000L) break; // prevent unnecessary overflow growth
                curr = curr * curr;
                if (curr > (long) 1e18) break;
            }

            // Add center if exists
            if (freq.getOrDefault(curr, 0) >= 1) {
                len += 1;
            } else {
                len -= 1; // last pair cannot be fully used without a center
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}