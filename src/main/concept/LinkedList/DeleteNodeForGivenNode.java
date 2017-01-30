package main.concept.LinkedList;

/**
 * Created by nirmodi on 1/29/17.
 */
public class DeleteNodeForGivenNode {

    public static void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] str) {
        ListNode ln1 = new ListNode(0);
        ListNode ln2 = new ListNode(1);

        ln1.next = ln2;
        deleteNode(ln1);

        System.out.print(ln1.val);
    }
}
