package main.java.Impl.leetcode.year2017;


import java.util.Stack;

/**
 * Created by nirmodi on 2/20/17.
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        int result = 0;
        int temp = 0;
        Stack<Character> data = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)) {
                case 'I':
                    if((temp != 0) && (!data.isEmpty()) && (data.peek() != 'I')){
                        result += temp;
                        temp = 0;
                    }
                    data.push('I');
                    temp++;
                    break;
                case 'V':
                    result += 5;
                    if(temp != 0 && (!data.isEmpty()) && (data.peek() == 'I')){
                        result -= temp;
                        temp = 0;
                    } else {
                        result += temp;
                        temp = 0;
                    }

                    break;
                case 'X':
                    if((temp != 0) && (!data.isEmpty()) && (data.peek() == 'I')){
                        result += 10;
                        result -= temp;
                        temp = 0;
                    } else {
                        if(temp != 0) {
                            result += temp;
                            temp = 0;
                        }
                        data.push('X');
                        temp += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    if(temp != 0 && (!data.isEmpty()) && (data.peek() == 'I' || data.peek() == 'X')){
                        result -= temp;
                        temp = 0;
                    } else {
                        result += temp;
                        temp = 0;
                    }
                    break;
                case 'C':
                    if((temp != 0) && (!data.isEmpty()) && (data.peek() == 'I' || data.peek() == 'X')){
                        result += 100;
                        result -= temp;
                        temp = 0;
                    } else {
                        if(temp != 0) {
                            result += temp;
                            temp = 0;
                        }
                        data.push('C');
                        temp += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    if(temp != 0 && (!data.isEmpty()) && (data.peek() == 'I' || data.peek() == 'X' || data.peek() == 'C' )){
                        result -= temp;
                        temp = 0;
                    } else {
                        result += temp;
                        temp = 0;
                    }
                    break;
                case 'M':
                    result += 1000;
                    if((temp != 0) && (!data.isEmpty()) && (data.peek() == 'I' || data.peek() == 'X' || data.peek() == 'C' )){
                        result -= temp;
                        temp = 0;
                    } else {
                        result += temp;
                        temp = 0;
                    }
                    break;
            }
        }
        if(temp != 0){
            result += temp;
        }
        return result;

    }

    public static int romanToIntBestSolution(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.print(romanToIntBestSolution("MMMCDXXXV"));
    }
}
