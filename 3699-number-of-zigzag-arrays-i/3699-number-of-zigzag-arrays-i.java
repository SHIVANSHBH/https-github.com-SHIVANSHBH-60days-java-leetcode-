class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int m = r - l + 1;
        if (n == 1) return m;

        long[] up = new long[m];
        long[] down = new long[m];
        for (int i = 0; i < m; i++) {
            up[i] = 1;
            down[i] = 1;
        }

        for (int pos = 2; pos <= n; pos++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            if (pos == 2) {
                for (int v = 0; v < m; v++) {
                    newUp[v] = v;
                    newDown[v] = m - 1 - v;
                }
            } else {
                long[] prefDown = new long[m];
                prefDown[0] = down[0];
                for (int i = 1; i < m; i++)
                    prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;

                long[] suffUp = new long[m];
                suffUp[m - 1] = up[m - 1];
                for (int i = m - 2; i >= 0; i--)
                    suffUp[i] = (suffUp[i + 1] + up[i]) % MOD;

                for (int v = 0; v < m; v++) {
                    newUp[v] = v > 0 ? prefDown[v - 1] : 0L;
                    newDown[v] = v < m - 1 ? suffUp[v + 1] : 0L;
                }
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) ans = (ans + up[i] + down[i]) % MOD;
        return (int) ans;
    }
}
