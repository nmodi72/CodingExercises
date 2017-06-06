package main.leetcode;

/**
 * 504. Base 7
 *
 * Input: 100 Output: "202"
 * Input: -7 Output: "-10"
 */
public class Base7 {

    public static String convertToBase7(int num) {
        String str = "";
        if(num < 0){
            str =  "-" + convertToBase7(-num);
        } else if(num < 7){
            str = num % 7 + "";
        } else {
            str = convertToBase7(num / 7) + (num % 7);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                sb.append("a");
            } else if(str.charAt(i) == '2'){
                sb.append("t");
            }  else if(str.charAt(i) == '3'){
                sb.append("l");
            } else if(str.charAt(i) == '4'){
                sb.append("s");
            } else if(str.charAt(i) == '5'){
                sb.append("i");
            } else if(str.charAt(i) == '6'){
                sb.append("n");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    public static void main(String[] args){
        System.out.print(convertToBase7(7792875));
    }
}
