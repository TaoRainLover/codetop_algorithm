package linkedlist;

/**
 * @author: Tao
 * @Date: 2024/03/12 12:29
 * @Description: 反转链表2
 */

public class ReverseListII {
    /**
     * 反转链表-使用方法1
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preNode = null;
        // 遍历反转位置
        ListNode node = head;
        int index = 1;
        while (node != null && index < left) {
            preNode = node;
            node = node.next;
            index++;
        }

        // if (index > 0) preNode = node;
        // 反转 left->right
        ListNode tmpNode = node;
        ListNode pre = null;
        ListNode cur = node;
        ListNode next = node;
        while (cur != null && index <= right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;
        }
        // 拼接
        if (preNode != null) preNode.next = pre;
        if (tmpNode != null) tmpNode.next = next;
        if (left > 1) return head;
        return pre;
    }


    /**
     * 反转链表-使用额外一个数组进行存
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (right <= left) return head;
        int[] nums = new int[right-left+1];
        ListNode node = head;
        int pos = 1;
        while(node.next != null && pos < left) {
            node = node.next;
            pos++;
        }
        ListNode begin = node;
        while(node != null && pos <= right) {
            nums[pos - left] = node.val;
            node = node.next;
            pos++;
        }
        node = begin;
        pos = left;
        while (node != null && pos <= right) {
            node.val = nums[right-pos];
            node = node.next;
            pos++;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);
        node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        ListNode listNode = ReverseListII.reverseBetween(node1, 1, 1);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
