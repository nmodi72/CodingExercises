package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionOfActionsKarat {
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


  public static void main(String[] args) {
//
//    HashMap<Integer,List<String>> map = new HashMap<>();
//
//    for(List<String> k : ip){
//      String s = k.get(0);
//      int id = Integer.parseInt(k.get(1));
//
//      if(map.containsKey(id)){
//        map.get(id).add(s);
//      }else{
//        map.put(id,new ArrayList<>());
//        map.get(id).add(s);
//      }
//    }
//
//    System.out.println(map);
//
//    for(int i : map.keySet()){
//      String x = String.join("",map.get(i));
//      if(x.length() > err.length()){
//        for(int  l = 0; l< x.length()-err.length()+1;l++){
//          String sub = x.substring(l,l+err.length());
//          if(sub.equals(err)){
//            res.add(i);
//          }
//        }
//
//      }else if(x.length() == err.length()){
//        if(x.equals(err)){
//          res.add(i);
//        }
//      }
//    }
//
//
//    System.out.println(res);
  }



}
