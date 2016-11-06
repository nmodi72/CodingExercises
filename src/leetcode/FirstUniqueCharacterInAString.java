package leetcode;

/**
 * This is the leetcode problem: # 387
 * First unique character in a string
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    // 15ms - beat 98.22 % other submissions
    public int firstUniqChar(String s) {
        int[] table = new int[128];
        for (char c : s.toCharArray())   table[c]++;
        int index = 0;
        for (char c : s.toCharArray()) {
            if (table[c] == 1) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
}
