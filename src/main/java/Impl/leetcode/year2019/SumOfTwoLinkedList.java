package main.java.Impl.leetcode.year2019;

import main.java.model.ListNode;

public class SumOfTwoLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = l1.val + l2.val;
        int carry = temp > 9 ? 1 : 0;
        ListNode result = new ListNode(temp %10);
        ListNode curr = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val;
            curr = new ListNode((temp + carry) % 10);
            carry = temp + carry > 9 ? 1 : 0;
            curr.next = null;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            curr = new ListNode((temp + carry) % 10);
            carry = temp + carry > 9 ? 1 : 0;
            curr.next = null;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr = new ListNode((temp + carry) % 10);
            carry = temp + carry > 9 ? 1 : 0;
            curr.next = null;
            l2 = l2.next;
        }
        return curr;
    }

    public ListNode reverse(ListNode l1) {
        ListNode prev = null;
        ListNode curr = l1;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        l1 = prev;
        return l1;
    }

    static boolean checkPalindrome(String inputString) {
        if (inputString == null || inputString.length() == 0) return true;
        char[] array = inputString.toCharArray();
        int i = 0;
        int j = inputString.length() - 1;
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        System.out.println(checkPalindrome("abcd"));
    }
}
