import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {  // ✅ List<Integer> in, int[] out
        if (nums == null) throw new IllegalArgumentException();
        
        int[] ans = new int[nums.size()];
        int idx = 0;
        
        for (int num : nums) {
            if ((num & 1) == 0) {           // Even → impossible
                ans[idx++] = -1;
                continue;
            }
            int t = Integer.numberOfTrailingZeros(~num);
            ans[idx++] = num - (1 << (t - 1));
        }
        return ans;
    }
}