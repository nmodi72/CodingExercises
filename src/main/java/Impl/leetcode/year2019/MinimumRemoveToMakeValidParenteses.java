package main.java.Impl.leetcode.year2019;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumRemoveToMakeValidParenteses {
    /*
    1249. Minimum Remove to Make Valid Parentheses
    Given a string s of '(' , ')' and lowercase English characters.

    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:

    It is the empty string, contains only lowercase characters, or
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.


    Example 1:
    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

    Example 2:
    Input: s = "a)b(c)d"
    Output: "ab(c)d"

    Example 3:
    Input: s = "))(("
    Output: ""
    Explanation: An empty string is also valid.
    Example 4:

    Input: s = "(a(b(c)d)"
    Output: "a(b(c)d)"
     */
    public String minRemoveToMakeValid(String str) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int skipChars = 0;
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ')' && open == 0) {
                skipChars++;
                continue;
            }
            if(str.charAt(i) == '(') {
                q.addLast(i-skipChars);
                open++;
            }
            if(str.charAt(i) == ')') {
                open--;
                q.removeLast();
            }
            sb.append(str.charAt(i));
        }
        int temp = 0;
        while(!q.isEmpty()) {
            sb.deleteCharAt(q.pollFirst()-temp);
            temp++;
        }
        return sb.toString();
    }
}
