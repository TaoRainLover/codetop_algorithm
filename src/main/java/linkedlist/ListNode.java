package linkedlist;

/**
 * @author: Tao
 * @Date: 2024/03/07 09:52
 * @Description:
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}