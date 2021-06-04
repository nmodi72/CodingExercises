package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    /*
    249. Group Shifted Strings
    Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

    "abc" -> "bcd" -> ... -> "xyz"
    Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

    Example:

    Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
    Output:
    [
      ["abc","bcd","xyz"],
      ["az","ba"],
      ["acef"],
      ["a","z"]
    ]
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> data = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].length() == 0) continue;
            String diffString = decodeDiffString(strings[i]);
            List<String> l = data.getOrDefault(diffString, new ArrayList<>());
            l.add(strings[i]);
            data.put(diffString, l);
        }
        return new ArrayList(data.values());
    }
    private String decodeDiffString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str.length(); i++){
            int prevChar = str.charAt(i-1);
            int currChar = str.charAt(i);
            int diff = 0;
            if (prevChar > currChar){
                diff = 26 + (currChar - prevChar);
            } else {
                diff = (currChar - prevChar);
            }
            sb.append(diff);
        }
        return sb.toString();
    }
}
