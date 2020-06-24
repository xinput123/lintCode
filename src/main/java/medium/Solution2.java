package medium;

import org.junit.Test;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(0);
        ListNode cur = sumNode;

        // 进位标志
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10; // 计算进位
            int value = sum % 10;

            cur.next = new ListNode(value);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return sumNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void ttt() {
        ListNode _342 = new ListNode(2);
        _342.next = new ListNode(4);
        _342.next.next = new ListNode(3);

        ListNode _950 = new ListNode(0);
        _342.next = new ListNode(5);
        _342.next.next = new ListNode(9);

        ListNode sum = new Solution2().addTwoNumbers(_342, _950);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }
}
