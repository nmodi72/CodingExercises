package main.java.Impl.leetcode.year2019;

public class VerifyingAnAlienDictionary {
    /*
    953 Verifying an Alien Dictionary
    In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

    Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

    Example 1:

    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    Output: true
    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
    Example 2:

    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    Output: false
    Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
     */
    int[] data = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length < 1) return true;
        for(int i = 0; i < order.length(); i++) {
            data[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++) {
            if(!isAlienSorted(words[i-1], words[i], order)) return false;
        }
        return true;
    }

    private boolean isAlienSorted(String word1, String word2, String order) {
        int i = 0;
        while(i < word1.length() && i < word2.length()){
            int index1 = data[word1.charAt(i) - 'a'];
            int index2 = data[word2.charAt(i) - 'a'];
            if(index1 < index2) return true;
            else if (index1 > index2) return false;
            else i++;
        }
        return word1.length() <= word2.length();
    }
}
