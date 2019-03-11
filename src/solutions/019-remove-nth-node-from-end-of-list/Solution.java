// Given a linked list, remove the n-th node from the end of list and return its head.
//
// Example:
//
//
// Given linked list: 1->2->3->4->5, and n = 2.
//
// After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int len = getLength(head);
        System.out.println(len);
        if(n==len){
            return head.next;
        }
        int flag=0;
        if(n==1){
            while(head!=null){
                if(flag==len-1-1){
                    head.next=null;
                    break;
                }else{
                    flag+=1;
                    head=head.next;
                }
            }
        }else{
                while(head!=null){
                if(flag==len-n-1){
                    head.next=head.next.next;
                    break;
                }else{
                    flag+=1;
                    head=head.next;
                }
            }
        }
        return tmp;
    }
    
    public int getLength(ListNode head){
        int count = 0;
        while(head!=null){
            count+=1;
            head=head.next;
        }
        return count;
    }
    
}
