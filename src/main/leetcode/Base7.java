package main.leetcode;

/**
 * 504. Base 7
 *
 * Input: 100 Output: "202"
 * Input: -7 Output: "-10"
 */
public class Base7 {

    public String convertToBase7(int num) {
        if(num < 0){
            return "-" + convertToBase7(-num);
        } else if(num < 7){
            return num % 7 + "";
        } else {
            return convertToBase7(num / 7) + (num % 7);
        }

    }
}
