class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int ops = 0;
        for (int n : nums) {
            int complement = k - n;
            if (freq.getOrDefault(complement, 0) > 0) {
                ops++;
                freq.put(complement, freq.get(complement) - 1);
            } else {
                freq.put(n, freq.getOrDefault(n, 0) + 1);
            }
        }
        return ops;
    }
}