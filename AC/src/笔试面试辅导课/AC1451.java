package 笔试面试辅导课;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AC1451 {
    public static void main(String[] args) {

    }

    static ListNode get_tail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static ListNode quickSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = new ListNode(-1), mid = new ListNode(-1), r = new ListNode(-1);
        ListNode ltail = l, midtail = mid, rtail = r;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < head.val) {
                ltail = ltail.next = cur;

            } else if (cur.val == head.val) {
                midtail = midtail.next = cur;
            } else {
                rtail = rtail.next = cur;
            }
        }
        ltail.next = null;
        midtail.next = null;
        rtail.next = null;
        l.next = quickSortList(l.next);
        r.next = quickSortList(r.next);
        get_tail(l).next = mid.next;
        get_tail(l).next = r.next;
        return l.next;


    }
}
