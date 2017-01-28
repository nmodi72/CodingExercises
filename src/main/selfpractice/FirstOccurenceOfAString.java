package main.selfpractice;

/**
 * This was asked in bloomberg interview
 *
 * Find the first occurence of any character of String A into StringB
 *
 * Example:
 * Input:
 * String A : "adf6ysh"
 * String B : "123456"
 *
 * Output : 3
 */
public class FirstOccurenceOfAString {

    public int findFirstOccurence(String str1, String str2) {
        int[] table = new int[128];
        char[] charArrayStr1 = str1.toCharArray();
        for(char character : charArrayStr1) {
            table[character]++;
        }
        char[] charArrayStr2 = str2.toCharArray();
        for(int i = 0; i < charArrayStr2.length; i++) {
            if(table[charArrayStr2[i]] > 0)     return i;
        }
        return -1;
    }
}

