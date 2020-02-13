package main.java.Impl.concept.Trie;

import main.java.model.TrieNode;

/**
 * This is example of dictionary function with using trie data structure
 */
public class DictionaryWithTrie {

    static TrieNode root = new TrieNode();

//    public void insert(String key) {
//        int level;
//        int length = key.length();
//        int index;
//        TrieNode currentRoot = root;
//        for(level = 0; level < length; level++) {
//            index = key.charAt(level) - 'a';
//            if(currentRoot.children[index] ==  null) {
//                currentRoot.children[index] = new TrieNode();
//            }
//            currentRoot = currentRoot.children[index];
//        }
//        currentRoot.isEndOfWord = true;
//    }
    public void insert(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for(level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

}
