class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, current = 0;
        for (int g : gain) {
            current += g;
            if (current > max) max = current;
        }
        return max;
    }
}