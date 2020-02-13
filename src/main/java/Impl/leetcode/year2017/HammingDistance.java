package main.java.Impl.leetcode.year2017;

/**
 * 461. Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 231.
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
*         ↑   ↑
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);

        StringBuilder sbX = new StringBuilder();
        sbX.append(xStr);
        sbX = sbX.reverse();

        StringBuilder sbY = new StringBuilder();
        sbY.append(yStr);
        sbY = sbY.reverse();

        int result = 0;
        for (int i = 0; i < Math.max(xStr.length(), yStr.length()); i++) {
            if (i < xStr.length() && i >= yStr.length() ) {

                if (sbX.charAt(i) == '1') {
                    result++;
                }
            }
            else if (i >= xStr.length()&& i < yStr.length()) {
                if (sbY.charAt(i) == '1') {
                    result++;
                }
            }
            else {
                if (sbX.charAt(i) != sbY.charAt(i)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(hammingDistance(1, 4));
    }
}
