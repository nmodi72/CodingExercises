package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    /*
    127. Word Ladder
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list.
    Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.
    Example 1:

    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5

    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.
    Example 2:

    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: 0

    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> wordSet = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<>();

        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        while(!q.isEmpty()) {
            count++;
            int qSize = q.size();
            while (qSize > 0) {
                String popWord = q.poll();
                for (int i = 0; i < popWord.length(); i++){
                    List<String> listStr = replaceCharacter(i, popWord);
                    if (!Collections.disjoint(listStr, wordList))
                        for (String s : listStr) {
                            if (visited.contains(s) || !wordSet.contains(s)) continue;
                            if(s.equals(endWord)) return count+1;
                            visited.add(s);
                            q.add(s);
                        }
                }
                qSize--;
            }
        }
        return 0;
    }

    private List<String> replaceCharacter(Integer id, String str) {
        List<String> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            String s = str.substring(0, id) + c + str.substring(id+1);
            if (!s.equals(str)) list.add(s);
        }
        return list;
    }
}
