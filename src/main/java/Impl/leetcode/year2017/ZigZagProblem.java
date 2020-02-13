package main.java.Impl.leetcode.year2017;

/**
 * This is the leetcode problem: #6
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagProblem {

    public static String convert1(String s, int numRows) {
        if (s.isEmpty() || numRows <= 0){
            return null;
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        // step
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    stringBuilder.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    stringBuilder.append(s.charAt(j));
                    if(flag) {
                        j = j + step1;
                    } else {
                        j = j + step2;
                    }
                    flag = !flag;
                }
            }
        }
    return stringBuilder.toString();
    }


    public static String convertString(String s, int rows) {
       int numRows = rows;
       if(rows % 2 == 1) {
            numRows = rows + 1;
       }

       if (s == null || s.length() < numRows) {
          return s;
       }
       StringBuilder sb = new StringBuilder();
       for (int i = 1; i < numRows; i++) {
           if (i == (numRows / 2)) {
               int temp = i - 1;
               while (temp < s.length()) {
                   sb.append(s.charAt(temp));
                   temp = temp + (numRows / 2) ;
               }
           } else {
               int temp = i - 1;
               while (temp < s.length()) {
                   sb.append(s.charAt(temp));
                   temp = temp + numRows;
               }
           }
       }
       return sb.toString();
    }
}
