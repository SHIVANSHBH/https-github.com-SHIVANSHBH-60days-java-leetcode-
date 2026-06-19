class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        reverse(a, 0, n - 1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (a[j] != ' ') {
                int start = i;
                while (j < n && a[j] != ' ') a[i++] = a[j++];
                reverse(a, start, i - 1);
                if (i < n) a[i++] = ' ';
            }
        }
        return new String(a, 0, i > 0 && a[i - 1] == ' ' ? i - 1 : i);
    }

    private void reverse(char[] a, int l, int r) {
        while (l < r) {
            char t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
    }
}