//Given a linked list, swap every two adjacent nodes and return its head.
//
// You may not modify the values in the list's nodes, only nodes itself may be c
//hanged.
//
//
//
// Example:
//
//
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode prevNode = new ListNode(0);
        ListNode newHead = prevNode;
        prevNode.next = head;

        while(prevNode.next != null && prevNode.next.next != null){
            ListNode node1 = prevNode.next;
            ListNode node2 = prevNode.next.next;
            ListNode nextNode = node2.next;

            prevNode.next = node2;
            node2.next = node1;
            node1.next = nextNode;

            prevNode = node1;
        }
        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
