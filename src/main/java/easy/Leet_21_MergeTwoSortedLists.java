package easy;

/**
 * Merge Two Sorted Lists
 * 合并两个有序list集合
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-09 00:04
 */
public class Leet_21_MergeTwoSortedLists {
    /**
     * Runtime: 0 ms
     * Memory Usage: 40.6 MB
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakehead = new ListNode(-1);
        ListNode l3 = fakehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            l3.next = l1;
        }

        if (l2 != null) {
            l3.next = l2;
        }

        return fakehead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
