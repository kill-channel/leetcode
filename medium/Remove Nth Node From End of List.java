//Given a linked list, remove the n-th node from the end of list and return its
//head.
//
// Example:
//
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->
//5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
// Related Topics Linked List Two Pointers


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumHead = new ListNode(0);
        ListNode lead = dumHead, tail = dumHead;
        dumHead.next = head;
        for (int i = 0; i <= n; i++) {
            tail = tail.next;
        }
        while (tail != null) {
            tail = tail.next;
            lead = lead.next;
        }
        lead.next = lead.next.next;
        return dumHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
