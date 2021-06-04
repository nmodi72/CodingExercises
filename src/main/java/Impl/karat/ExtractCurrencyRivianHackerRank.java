package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExtractCurrencyRivianHackerRank {
/*
   Given a collection of actions and userIds an error occurs when a userId takes a specific action in order for example

    A => B => => C gives an errror
    B => A => C no error and etc

    Write a function that takes in a list of (Actions, UserIds) pairs and returns the user Id that ecounters the error

    Sample Input:

    action_user_1 = [
    ["A", "1"],
    ["B", "1"],
    ["B", "2"],
    ["C", "1"],
    ["C", "2"],
    ["C", "3"],
    ["A", "2],
    ["A", "3"],
    ["A", "2"],
    ["B", "2],
    ["C", "2"],
    ]

    Expected output 1,2

    action_user_2 = [
    ["A", "1"],
    ["A", "1"]
    ["A", "1"]
    ["B", "1"],
    ["B", "2"],
    ["C", "2"],
    ["C", "2"],
    ["C", "3"],
    ["A", "2],
    ["A", "3"],
    ["A", "2"],
    ["B", "2],
    ["C", "2"],
    ]

    Expected output 2
 */

  static Set<Integer> validCurrency;
  public static int countCounterfeit(List<String> serialNumber) {
    loadValidData();
    int result = 0;
    for(String str : serialNumber){
      result += validateAndExtractAmount(str);
    }
    return result;
  }

  private static void loadValidData(){
    validCurrency = new HashSet<>();
    validCurrency.add(10);
    validCurrency.add(20);
    validCurrency.add(50);
    validCurrency.add(100);
    validCurrency.add(200);
    validCurrency.add(500);
    validCurrency.add(1000);

  }
  private static int validateAndExtractAmount(String str){
    int result = 0;
    if (str.length() < 10 || str.length() > 12) return result; // length check

    Set<Character> visited = new HashSet<>();
    int year = 0;
    for(int i = 0; i < str.length(); i++){
      Character curr = str.charAt(i); //AVG - 1904 - 2
      // make sure the first three chars are upper and unique
      if(i < 3) {
        if(!(Character.isAlphabetic(curr) && Character.isUpperCase(curr)) || visited.contains(curr)) {
          return result; // break condition
        }
        visited.add(curr);
      } else if (i < 7) {
        // next four chars are digit, in years between 1900-2019
        if(!Character.isDigit(curr)) return result; // break. condition on non-number
        year = (year * 10) + (curr - '0');
      } else {
        if(i == 7 && (year < 1900 || year > 2019)) return result; // year check
        // next 3/4 chars / until the digits comes, need to make sure it exists in validCurrenccy
        int currency = 0;
        // build currency
        for(int j = i; j < str.length()-1; j++) {
          Character c = str.charAt(j);
          if(!Character.isDigit(c)) return 0;
          currency = (currency * 10) + c - '0';
          i = j;
        }
        if(!validCurrency.contains(currency)) return 0; // in valid denomination
        // last character should be Upper case
        i++;
        curr = str.charAt(i);
        if(i != str.length()-1 || !(Character.isAlphabetic(curr) && Character.isUpperCase(curr))) return 0;
        return currency;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    List<String> input = new ArrayList<>();
    input.add("AVG190420T");
    System.out.println(countCounterfeit(input));
  }


}
