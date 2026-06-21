class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int n : nums1) s1.add(n);
        for (int n : nums2) s2.add(n);
        List<Integer> only1 = new ArrayList<>(), only2 = new ArrayList<>();
        for (int n : s1) if (!s2.contains(n)) only1.add(n);
        for (int n : s2) if (!s1.contains(n)) only2.add(n);
        return List.of(only1, only2);
    }
}