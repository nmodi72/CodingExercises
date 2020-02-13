package main.java.model;

/**
 * Definition for trie data structure.
 */
public class TrieNode {
    public static final int ALPHABET_SIZE = 26;
    public TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    public boolean isEndOfWord;
    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < ALPHABET_SIZE; i++)
            children[i] = null;
    }

}
