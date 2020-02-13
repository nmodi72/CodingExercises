package main.java.Impl.leetcode.year2017;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class BinaryWatch {


    public static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 60; j++){
                int n = Integer.bitCount(i * 64 + j);
                if(n == num){
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = readBinaryWatch(2);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
