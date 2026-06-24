class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) return m;
        if (n == 2) return (int)((long) m * (m - 1) % MOD);

        long[] up = new long[m];
        long[] down = new long[m];
        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - 1 - i;
        }

        int steps = n - 2;
        int p = steps / 2;
        int rem = steps % 2;

        long[][] Ap = matrixPow(m, p);

        long[] newUp, newDown;
        if (rem == 0) {
            newUp = mulMV(Ap, up);
            newDown = rev(mulMV(Ap, rev(down)));
        } else {
            long[] t = rev(mulMV(Ap, rev(down)));
            newUp = prefixSum(t);
            t = mulMV(Ap, up);
            newDown = suffixSum(t);
        }

        long ans = 0;
        for (int i = 0; i < m; i++) ans = (ans + newUp[i] + newDown[i]) % MOD;
        return (int) ans;
    }

    long[][] matrixPow(int m, int e) {
        long[][] r = identity(m);
        long[][] b = buildA(m);
        while (e > 0) {
            if ((e & 1) == 1) r = mul(r, b);
            b = mul(b, b);
            e >>= 1;
        }
        return r;
    }

    long[][] identity(int m) {
        long[][] I = new long[m][m];
        for (int i = 0; i < m; i++) I[i][i] = 1;
        return I;
    }

    long[][] buildA(int m) {
        long[][] A = new long[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                A[i][j] = Math.min(i, j);
        return A;
    }

    long[][] mul(long[][] a, long[][] b) {
        int m = a.length;
        long[][] c = new long[m][m];
        for (int i = 0; i < m; i++)
            for (int k = 0; k < m; k++)
                if (a[i][k] != 0)
                    for (int j = 0; j < m; j++)
                        c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
        return c;
    }

    long[] mulMV(long[][] mat, long[] v) {
        int m = v.length;
        long[] r = new long[m];
        for (int i = 0; i < m; i++) {
            long s = 0;
            for (int j = 0; j < m; j++)
                s = (s + mat[i][j] * v[j]) % MOD;
            r[i] = s;
        }
        return r;
    }

    long[] rev(long[] v) {
        int m = v.length;
        long[] r = new long[m];
        for (int i = 0; i < m; i++) r[i] = v[m - 1 - i];
        return r;
    }

    long[] prefixSum(long[] v) {
        int m = v.length;
        long[] r = new long[m];
        long s = 0;
        for (int i = 0; i < m; i++) {
            r[i] = s;
            s = (s + v[i]) % MOD;
        }
        return r;
    }

    long[] suffixSum(long[] v) {
        int m = v.length;
        long[] r = new long[m];
        long s = 0;
        for (int i = m - 1; i >= 0; i--) {
            r[i] = s;
            s = (s + v[i]) % MOD;
        }
        return r;
    }
}
