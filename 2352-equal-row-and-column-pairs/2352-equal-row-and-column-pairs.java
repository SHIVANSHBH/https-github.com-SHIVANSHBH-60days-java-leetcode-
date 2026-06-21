class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) col[i] = grid[i][j];
            count += map.getOrDefault(Arrays.toString(col), 0);
        }
        return count;
    }
}