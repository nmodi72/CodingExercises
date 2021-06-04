package main.java.Impl.leetcode.year2019;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static int findPrimeSeries(int index) {
        if (index == 0) return 4;
        int max = (index * index) * 2;
        boolean[] data = new boolean[max];
        for (int i = 2; i < index + 1; i++) {
            int j = 2;
            while (Math.pow(i, j) < max) {
               int res = (int) Math.pow(i, j);
               data[res] = true;
               j++;
            }
        }
        int counter = -1;
        for (int ct = 0; ct < data.length; ct++) {
            if (data[ct]) {
                ++counter;
                if (counter == index) {
                    return ct;
                }
            }
        }
        return -1;
    }

    static void drawCircle(int a, int b, int r)
    {
        for (int angle = 0; angle < 360; ++angle)
        {
            double x = a + (r * cos(angle));
            double y = b + (r * sin(angle));
            System.out.println("x:" + x + ", y:" + y);
        }
    }

    public static void main(String[] args) {
        Solution.drawCircle(5, 5, 5);
    }



}
