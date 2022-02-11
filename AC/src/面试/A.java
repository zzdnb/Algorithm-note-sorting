package 面试;

import java.util.List;

import static 面试.A.get_tail;

public class A {
    public static void main(String[] args) {

    }

    public ListNode quickSortList(ListNode head) {
        //如果链表中没有数或者只有一个数的话，就return
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(-1), mid = new ListNode(-1), right = new ListNode(-1);
        //定义队尾
        ListNode ltail = left, mtail = mid, rtail = right;
        int val = head.val;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < val) {
                ltail = ltail.next = p;
            } else if (p.val == val) {
                mtail = mtail.next = p;
            } else {
                rtail = rtail.next = p;
            }
        }
        ltail.next = mtail.next = rtail.next = null;
        left.next = quickSortList(left.next);
        right.next = quickSortList(right.next);
        //拼接三个链表
        get_tail(left).next = mid.next;
        get_tail(left).next = right.next;
        return left.next;
    }
    public static ListNode get_tail(ListNode head){
        while(head.next!=null){
            head = head.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}