package leetcode;

/**
 * This is the leetcode problem #171
 * Excel sheet column number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelSheetColumnNumber {

    // 2 ms - 54.85% beats
    public int titleToNumber(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int power = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if(i == (s.length() - 1)) {
                result += (charArray[i] - 64);
            }
            else {
                result += ((charArray[i] - 64) * (int) Math.pow(26, power));
            }
            power++;
        }
        return result;
    }
}
