class RecentCounter {
    private java.util.Queue<Integer> queue;

    public RecentCounter() {
        queue = new java.util.LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}