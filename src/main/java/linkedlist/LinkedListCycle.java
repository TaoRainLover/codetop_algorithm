package linkedlist;

/**
 * @author: Tao
 * @Date: 2024/03/12 13:56
 * @Description:
 */

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
