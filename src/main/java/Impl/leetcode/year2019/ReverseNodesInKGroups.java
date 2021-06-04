package main.java.Impl.leetcode.year2019;

import main.java.model.ListNode;

public class ReverseNodesInKGroups {

    static ListNode reverseNodesInKGroups(ListNode l, int k) {
        ListNode root = l;
        ListNode begin = new ListNode(-1);
        ListNode dummyBegin = begin;
        ListNode next = new ListNode(-1);
        ListNode prevNext = new ListNode(-1);

        ListNode dummyResult = new ListNode(-1);
        ListNode result = dummyResult;

        int step = 0;
        while (root != null) {
            step++;
            begin.next = root;
            begin = begin.next;
            next = root.next;
            if (step == k) {
                begin.next = null;
                ListNode methodResultNode = reverse(dummyBegin.next);
                root = next;
                begin = new ListNode(-1);
                dummyBegin = begin;
                dummyResult.next = methodResultNode;
                while (dummyResult.next != null) dummyResult = dummyResult.next;
                prevNext = new ListNode(-1);
                prevNext.next = next;
                step = 0;
            } else {
                root = root.next;
            }
        }
        prevNext = prevNext.next;
        while(prevNext != null) {
            dummyResult.next = prevNext;
            dummyResult = dummyResult.next;
            prevNext = prevNext.next;
        }
        return result.next;
    }

    static ListNode reverse(ListNode root) {
        ListNode head = root;
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next.next = new ListNode(8);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(10);
        l1.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

        ListNode result = reverseNodesInKGroups(l1, 3);

        System.out.println("abcd");
    }
}
