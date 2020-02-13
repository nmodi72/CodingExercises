package main.java.Impl.selfpractice;

/**
 * This is self practice code
 *
 * Find the second highest element from Array
 *
 */
public class FindSecondHighestElementFromArray {

    public int findSecondHighestElementFromArray(int[] array) {
        int highestElement = Integer.MIN_VALUE, secondHighestElement = Integer.MIN_VALUE;
        for (int number : array) {
            if (number > highestElement) {
                secondHighestElement = highestElement;
                highestElement = number;
            }
        }
        return secondHighestElement;
    }
}
