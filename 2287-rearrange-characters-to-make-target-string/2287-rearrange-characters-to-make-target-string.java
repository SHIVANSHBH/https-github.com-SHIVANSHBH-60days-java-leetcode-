class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] fs = new int[26], ft = new int[26];
        for (char c : s.toCharArray()) fs[c - 'a']++;
        for (char c : target.toCharArray()) ft[c - 'a']++;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (ft[i] > 0) min = Math.min(min, fs[i] / ft[i]);
        }
        return min;
    }
}