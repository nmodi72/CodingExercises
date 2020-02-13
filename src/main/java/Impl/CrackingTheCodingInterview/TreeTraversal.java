package main.java.Impl.CrackingTheCodingInterview;

import java.util.Map;
import java.util.TreeMap;

public class TreeTraversal {

    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;

        for (int i = start; i <= end; i++)
            count++;
        System.out.println(count);


//        System.out.println(WordCount("blue fish red fish"));
    }

    public static String WordCount(String toCount){

        String[] str = toCount.split(" ");
        StringBuilder sb = new StringBuilder();
        TreeMap<String,Integer> map = new TreeMap<String,Integer>();

        for(String word: str ){
            if(map.containsKey(word)){
                map.put(word.toLowerCase(), map.get(word)+1);

            }else{
                map.put(word.toLowerCase(),1);
            }
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sb.append(entry.getKey() + " - " + entry.getValue()+ "; ");
        }
        return sb.toString();
    }
}
