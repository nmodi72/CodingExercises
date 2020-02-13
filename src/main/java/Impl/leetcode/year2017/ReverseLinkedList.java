package main.java.Impl.leetcode.year2017;

/**
 * This is leetcode problem # 206
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode resultNode = new ListNode(head.val);
        while (head.next != null) {
            head = head.next;
            ListNode nextNode = new ListNode(head.val);
            nextNode.next = resultNode;
            resultNode = nextNode;
        }
        return resultNode;
    }


    public ListNode reverseListNiceSolution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
