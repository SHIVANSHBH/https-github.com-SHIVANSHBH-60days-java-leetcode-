import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = (restrictions == null) ? 1 : restrictions.length + 1;
        int[][] cap = new int[m][2];

        cap[0][0] = 1;
        cap[0][1] = 0;

        if (restrictions != null) {
            for (int i = 0; i < restrictions.length; i++) {
                cap[i + 1][0] = restrictions[i][0];
                cap[i + 1][1] = restrictions[i][1];
            }
        }

        Arrays.sort(cap, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < m; i++) {
            int d = cap[i][0] - cap[i - 1][0];
            cap[i][1] = Math.min(cap[i][1], cap[i - 1][1] + d);
        }

        for (int i = m - 2; i >= 0; i--) {
            int d = cap[i + 1][0] - cap[i][0];
            cap[i][1] = Math.min(cap[i][1], cap[i + 1][1] + d);
        }

        int answer = 0;
        for (int i = 0; i < m - 1; i++) {
            int h1 = cap[i][1];
            int h2 = cap[i + 1][1];
            int d  = cap[i + 1][0] - cap[i][0];
            int peak = (h1 + h2 + d) / 2;
            if (peak > answer) answer = peak;
        }

        int tail = cap[m - 1][1] + (n - cap[m - 1][0]);
        if (tail > answer) answer = tail;

        return answer;
    }
}