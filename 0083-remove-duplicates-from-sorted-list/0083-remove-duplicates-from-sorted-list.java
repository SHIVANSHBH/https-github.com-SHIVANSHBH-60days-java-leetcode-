// Pattern: Pointer-chasing (skip adjacent duplicates)
// Sorted list → duplicates are next to each other; just reroute the pointer
// Time: O(n) | Space: O(1)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
