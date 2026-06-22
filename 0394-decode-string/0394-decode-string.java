class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> num = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                num.push(k);
                str.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = str.pop();
                int repeat = num.pop();
                for (int i = 0; i < repeat; i++) cur.append(tmp);
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}