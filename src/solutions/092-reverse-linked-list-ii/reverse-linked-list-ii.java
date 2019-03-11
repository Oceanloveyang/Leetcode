// Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
//
// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL
//
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pHead = new ListNode(0);
        ListNode pTail = null;
        ListNode pNext = null;
        ListNode pPrev = pHead;

        pHead.next = head;

        for(int i = 0; i < m - 1; i++) {
            pHead = pHead.next;
        }

        pTail = pHead.next;
        for (int i = m; i < n; i++) {
            pNext = pTail.next;
            pTail.next = pNext.next;
            pNext.next = pHead.next;
            pHead.next = pNext;
        }

        return pPrev.next;
    }
}
