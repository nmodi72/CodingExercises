package main.leetcode;

/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)  return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for(ListNode list: lists)
            if(list != null)  queue.offer(list);
        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            temp.next = n;
            temp = temp.next;
            if(n.next != null)
                queue.offer(n.next);
        }
        return result.next;
    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(2);
        ListNode list4 = new ListNode(3);
        ListNode list5 = new ListNode(4);
        ListNode list6 = new ListNode(5);

        list1.next = list2;
        list3.next = list6;
        list4.next = list5;

        ListNode[] listNodes = {list1, list3, list4};
        ListNode result = MergeKSortedLists.mergeKLists(listNodes);
    }
}
