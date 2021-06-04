package main.java.Impl.concept.LinkedList;

import java.util.List;

import main.java.model.ListNode;

public class IsListPalindrome {
    static boolean isListPalindrome(ListNode head) {
        // iterate
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;

    }

    static ListNode reverseList(ListNode l) {
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = l;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1000000000);
        l.next.next = new ListNode(-1000000000);
        l.next.next.next = new ListNode(-1000000000);
        l.next.next.next.next = new ListNode(1000000000);
        l.next.next.next.next.next = new ListNode(1);
        System.out.println("Answer:" + isListPalindrome(l));
    }
}
