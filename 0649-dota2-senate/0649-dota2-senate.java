class Solution {
    public String predictPartyVictory(String senate) {
        java.util.Queue<Integer> r = new java.util.LinkedList<>();
        java.util.Queue<Integer> d = new java.util.LinkedList<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') r.offer(i);
            else d.offer(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int ri = r.poll(), di = d.poll();
            if (ri < di) r.offer(ri + n);
            else d.offer(di + n);
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}