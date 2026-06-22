class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] f = new int[26];
        for (char c : text.toCharArray()) f[c - 'a']++;
        return Math.min(f['b' - 'a'],
               Math.min(f['a' - 'a'],
               Math.min(f['l' - 'a'] / 2,
               Math.min(f['o' - 'a'] / 2,
                        f['n' - 'a']))));
    }
}