package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class AccountsMerge {
    /*
    721. Accounts Merge
    Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

    Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

    After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

    Example 1:
    Input:
    accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
    Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
    Explanation:
    The first and third John's are the same person as they have the common email "johnsmith@mail.com".
    The second John and Mary are different people as none of their email addresses are used by other accounts.
    We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
    ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
    Note:

    The length of accounts will be in the range [1, 1000].
    The length of accounts[i] will be in the range [1, 10].
    The length of accounts[i][j] will be in the range [1, 30]
     */

    Map<Integer, List<String>> graph = new HashMap<>();
    Map<Integer, List<Integer>> mergeMap = new HashMap<>();
    Map<String, Integer> emailMap = new HashMap<>();
    boolean[] visited;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        fillGraphData(accounts);
        visited = new boolean[graph.size()];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            List<String> subResult = new ArrayList<>();
            subResult.add(accounts.get(i).get(0));
            subResult.addAll(traverse(i));
            result.add(subResult);
        }
        return result;
    }

    private List<String> traverse(Integer curr){
        Set<String> resultSet = new TreeSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        resultSet.addAll(graph.get(curr));
        visited[curr] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                List<Integer> childs = mergeMap.getOrDefault(poll, new ArrayList<>());
                for (int child : childs) {
                    if (visited[child]) continue;
                    visited[child] = true;
                    resultSet.addAll(graph.get(child));
                    q.add(child);
                }
            }
        }
        return new ArrayList<>(resultSet);
    }


    private void fillGraphData(List<List<String>> accounts) {
        int id = 0;
        for (List<String> acct : accounts) {
            List<String> emailList = new ArrayList<>();
            for (int i = 1; i < acct.size(); i++) {
                emailList.add(acct.get(i));
                Integer prevNode = emailMap.get(acct.get(i));
                if (prevNode != null) {
                    addRelation(prevNode, id);
                    addRelation(id, prevNode);
                }
                emailMap.put(acct.get(i), id);
            }
            graph.put(id++, emailList);
        }

    }

    private void addRelation(Integer node1, Integer node2) {
        List<Integer> lst = mergeMap.getOrDefault(node1, new ArrayList<>());
        lst.add(node2);
        mergeMap.put(node1, lst);
    }
}
