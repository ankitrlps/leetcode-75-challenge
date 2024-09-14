/*
 * 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 */

public class DeleteMiddleNodeOfLinkedList {
    
    public ListNode deleteMiddle(ListNode head) {
        int n = 0;
        ListNode runner = head;
        while (runner != null) {
            n++;
            runner = runner.next;
        }
        int mid = n/2;
        if (mid <= 0) return null;
        int i = 0;
        runner = head;
        while (runner != null) {
            if (i == mid-1) {
                runner.next = runner.next.next;
                break;
            }
            i++;
            runner = runner.next;
        }
        return head;
    }

    public static void main(String[] args) {
        
    }
}
