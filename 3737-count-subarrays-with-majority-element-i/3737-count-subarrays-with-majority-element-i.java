class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] arr = new int[n];
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                arr[i] = 1;
                found = true;
            } else {
                arr[i] = -1;
            }
        }

        if (!found) return 0;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefix[j] - prefix[i] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}