package linkedlist;

/**
 * @author: Tao
 * @Date: 2024/03/07 09:53
 * @Description:
 */

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args) {

    }
}
