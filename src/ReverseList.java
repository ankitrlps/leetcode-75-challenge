public class ReverseList {
    public static void main(String[] args) {
        
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode reversed = null;
        while (head != null) {
            ListNode helper = head.next;
            head.next = reversed;
            reversed = head;
            head = helper;
        }
        return reversed;
    }
}
