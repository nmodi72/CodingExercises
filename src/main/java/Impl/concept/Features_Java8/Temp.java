package main.java.Impl.concept.Features_Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nmodi on 7/25/17.
 */
public class Temp {


    static String[] friendlyWords(String[] input) {
        List<String> result = new ArrayList<String>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : input){
            String inp = Sort(s);
            // System.out.println(inp);
            if(map.containsKey(inp)){
            List<String> str = map.get(inp);
                str.add(s);
                map.put(inp,str);
            }
            else{
                List<String> sub = new ArrayList<String>();
                sub.add(s);
                map.put(inp,sub );
            }
        }

        for(String key : map.keySet()){
            List<String> print = map.get(key);
            Collections.sort(print);
    if(print.size() > 1){
    for(String s : print){
    result.add(s);
        System.out.print(s+" ");
    }
    System.out.println();
    }
    }
        String[] returnArray = (String[])result.toArray();
        return returnArray;

    }

    static String Sort(String s){
    char[] allChars = s.toCharArray();
    Arrays.sort(allChars);
    return String.valueOf(allChars);
    }


    public static void main(String[] args) {


        System.out.print("Result: " + -12 %10);
        String[] arg = {"abaa", "aaba"};
    }

}
