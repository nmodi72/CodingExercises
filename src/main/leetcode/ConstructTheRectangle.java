package main.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 492. Construct the Rectangle
 *
 * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your
 * job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
 *
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * 2. The width W should not be larger than the length L, which means L >= W.
 * 3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 *
 * Input: 4
 * Output: [2, 2]
 * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
 * But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2].
 * So the length L is 2, and the width W is 2.
 *
 * Note:
 * The given area won't exceed 10,000,000 and is a positive integer
 * The web page's width and length you designed must be positive integers.
 */
public class ConstructTheRectangle {
    public static int[] constructRectangle(int area) {
        int minLength = 1;
        int maxLength = area;
        Map data = new HashMap();
        for (int i = area; i > 0; i--) {
            if(area % i == 0) {
                data.put(i, area / i);
            }
        }
        Iterator it = data.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int min = (Integer) pair.getKey();
            int max = (Integer) pair.getValue();
            if(min >= max) {
                if(Math.abs(min-max) <= Math.abs(minLength - maxLength)) {
                    maxLength = min;
                    minLength = max;
                }
            }
        }
        int[] result = {maxLength, minLength};
        return result;
    }

    public static int[] constructRectangleAnotherSolution(int area) {
        int[] result = new int[2];
        if(area == 0) {
            return result;
        }
        int a = (int) Math.sqrt(area);
        while(area % a != 0) {
            a--;
        }
        int b = area / a;
        result[0] = b;
        result[1] = a;
        return result;
    }

    public static void main(String[] args) {

        int[] array = constructRectangleAnotherSolution(6);
        for(int i : array) {
            System.out.print(i + " ");
        }

    }

}
