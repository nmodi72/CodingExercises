package main.java.Impl.leetcode.year2017;

import java.util.LinkedList;
import java.util.Stack;

/**
 * This is leetcode problem # 445
 * Add Two Numbers 2
 *
 * You are given two linked lists representing two non-negative numbers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers2 {

    public LinkedList addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        int number1 = 0, number2 = 0, result = 0;
        LinkedList resultList = new LinkedList();
        for (int number : l1) {
            number1 = (number1 * 10) + number;
        }
        for (int number : l2) {
            number2 = (number2 * 10) + number;
        }
        result = number1 + number2;
        Stack<Integer> stack = new Stack<>();
        while (result > 0) {
            stack.push(result % 10);
            result = result / 10;
        }
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while(l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while(l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }

            int sum = 0;
            ListNode resultNode = new ListNode(0);
            while(!stack1.isEmpty() || !stack2.isEmpty()) {
                if(!stack1.isEmpty()) sum += stack1.pop();
                if(!stack2.isEmpty()) sum += stack2.pop();
                resultNode.val = sum % 10;
                ListNode newNode = new ListNode(sum / 10);
                newNode.next = resultNode;
                resultNode = newNode;
                sum = sum / 10;

            }

            return resultNode.val == 0 ? resultNode.next : resultNode;

        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}

