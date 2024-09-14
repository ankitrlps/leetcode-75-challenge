public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddRunner = head;
        ListNode evenRunner = head.next;
        ListNode evenPrev = head.next;

        while (evenRunner != null && evenRunner.next != null) {
            oddRunner.next = oddRunner.next.next;
            evenRunner.next = evenRunner.next.next;
            oddRunner = oddRunner.next;
            evenRunner = evenRunner.next;
        }
        oddRunner.next = evenPrev;
        return head;
    }

    public static void main(String[] args) {
        
    }
}
