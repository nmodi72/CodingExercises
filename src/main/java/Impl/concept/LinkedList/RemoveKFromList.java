package main.java.Impl.concept.LinkedList;

import main.java.model.ListNode;

public class RemoveKFromList {
    static ListNode removeKFromList(ListNode l, int k) {
        while (l != null && l.val == k) l = l.next;

        ListNode curr = l;
        while (curr != null && curr.next != null) {
            if (curr.next.val == k) {
                curr.next = curr.next.next;
            } else  {

            }
        }
        return l;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);

        ListNode result = removeKFromList(l, 1);
        System.out.println("Answer:" );
    }
}
