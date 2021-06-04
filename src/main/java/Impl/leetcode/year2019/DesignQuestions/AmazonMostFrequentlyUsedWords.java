package main.java.Impl.leetcode.year2019.DesignQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.*;

public class AmazonMostFrequentlyUsedWords {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> retrieveMostFrequentlyUsedWords(String helpText,
            List<String> wordsToExclude)
    {
        List<String> result = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < helpText.length(); i++) {
            if (Character.isLetter(helpText.charAt(i))) {
                sb.append(helpText.charAt(i));
            } else {
                if (sb.length() > 0) {
                    String s = sb.toString();
                    s = s.toLowerCase();
                    if(!wordsToExclude.contains(s)) {
                        map.put(s, map.getOrDefault(s, 0)+1);
                    }
                }
                sb = new StringBuilder();
            }

        }

        Map<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));


        Iterator<Map.Entry<String, Integer>> it = reverseSortedMap.entrySet().iterator();
        int count = 0;
        if (it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            count = e.getValue();
            result.add(e.getKey());
        }
        while(it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            if (e.getValue() != count) break;
            result.add(e.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        AmazonMostFrequentlyUsedWords a = new AmazonMostFrequentlyUsedWords();
        String str = "Rose is a flower red rose are flower";
        List<String> list = Arrays.asList("is", "are", "a");

        for (String s : a.retrieveMostFrequentlyUsedWords(str, list)) {
            System.out.println(s);
        }
    }
}
