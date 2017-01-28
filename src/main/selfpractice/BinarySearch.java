package main.selfpractice;

/**
 * Created by nirmodi on 1/8/17.
 */
public class BinarySearch {
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            String message = String.format("Lower bound: [%s], Upper bound: [%s], middle bound: [%s]", lo, hi, mid);
            System.out.println(message);
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public double power(double a, int b) {
        // Base case with 0 exponent
        if (b == 0) return 1;

        // Negative exponent
        if (b < 0) {
            return 1. / power(a, -b);
        }

        // General case of positive exponent
        double half = power(a, b / 2);
        return half * half * ( (b % 2 == 1) ? a : 1 );
    }
}
