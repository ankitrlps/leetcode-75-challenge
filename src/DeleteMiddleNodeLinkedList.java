public class DeleteMiddleNodeLinkedList {
    
    public static void main(String[] args) {
        
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev.next != null) {
            prev.next = slow.next;
            return head;
        }
        return null;
    }

    // here we have two runners - fast and slow - fast jumps two nodes each time and slow jumps on one node at the same time.
    // When node is determined as odd - then use the prev node to keep track of slow ~ if section
    // When node is determined as even - then use slow node to delete the node in between ~ else section
    // Odd or even is determined by fast.next and fast.next.next
    // fast.next == null during odd no. of nodes
    // fast.next.next == null during even no. of nodes
    public ListNode deleteMiddle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            prev.next = slow.next;
        } else {
            slow.next = slow.next.next;
        }
        
        return head;
    }

    // here we find the length of head and then remove the middle node by checking n/2
    public ListNode deleteMiddle1(ListNode head) {
        int n = 0;
        ListNode runner = head;
        while (runner != null) {
            n++;
            runner = runner.next;
        }

        if (n == 1) return null;
        
        runner = head;
        int i = 0;
        while (runner != null) {
            if (i + 1 == n/2) {
                ListNode prev = runner;
                prev.next = runner.next.next;
                runner = prev;
            }
            i++;
            runner = runner.next;
        }
        return head;
    }
}
