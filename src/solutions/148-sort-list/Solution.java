// Sort a linked list in O(n log n) time using constant space complexity.
//
// Example 1:
//
//
// Input: 4->2->1->3
// Output: 1->2->3->4
//
//
// Example 2:
//
//
// Input: -1->5->3->4->0
// Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode mid = slow.next;
        slow.next=null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return mergeTwoList(left, right);
        
    }
    
    public ListNode mergeTwoList(ListNode left, ListNode right){
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        if(left.val<=right.val){
            left.next = mergeTwoList(left.next,right);
            return left;
        }
        else{
            right.next= mergeTwoList(left, right.next);
            return right;
        }
        
    }
    
    
}
