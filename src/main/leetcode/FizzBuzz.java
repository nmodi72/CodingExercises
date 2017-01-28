package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is leetcode problem # 412
 * Fizz Buzz
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 * n = 15,
 * Return: ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        if(n < 1)   return null;
        List<String> returnList = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if(i % 15 == 0)     returnList.add("FizzBuzz");
            else if(i % 5 == 0)     returnList.add("Buzz");
            else if(i % 3 == 0)     returnList.add("Fizz");
            else    returnList.add(String.valueOf(i));
        }
        return returnList;
    }
}
