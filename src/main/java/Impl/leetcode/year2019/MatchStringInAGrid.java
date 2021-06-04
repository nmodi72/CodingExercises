package main.java.Impl.leetcode.year2019;

import java.util.ArrayList;
import java.util.List;

public class MatchStringInAGrid {
    /*
        Given matrrix find a word locations

        char[][] grid = {
                    { 'c', 'c', 'd', 'e'},
                    { 'r', 'd', 'd', 's'},
                    { 'd', 'v', 's', 'q'},
                    { 'b', 'a', 't', 'b'},
                    { 'z', 'c', 'd', 'e'}};

        look for "crdvs" -> return it;s indexes
      */
    public List<String> getPath(char[][] input, String word) {
        int r = input.length;
        int c = input[0].length;
        for (int i=0; i< r; i++) {
            for(int j=0; j< c; j++) {
                List<String> res = matchWord(input, i,j, word);
                if (res != null) {
                    return res;
                }
            }
        }

        return new ArrayList<String>();
    }

    private List<String> matchWord(char[][] input, int i, int j, String word) {
        if (word.length() == 0) {
            return new ArrayList<String>();
        }

        char c = word.charAt(0);
        if (word.length() == 1 && input[i][j] == c) {
            List<String> res = new ArrayList<String>();
            res.add(i + "," + j);
            return res;
        }

        if (input[i][j] != c) return null;

        if (j + 1 < input[0].length) {
            List<String> res = matchWord(input, i,j+1, word.substring(1));
            if (res != null) {
                res.add(i + "," + j);
                return res;
            }
        }

        if (i + 1 < input.length) {
            List<String> res = matchWord(input, i +1,j, word.substring(1));
            if (res != null) {
                res.add(i + "," + j);
                return res;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        char[][] grid = {
                { 'c', 'c', 'd', 'e'},
                { 'r', 'd', 'd', 's'},
                { 'd', 'v', 's', 'q'},
                { 'b', 'a', 't', 'b'},
                { 'z', 'c', 'd', 'e'}};

        MatchStringInAGrid s = new MatchStringInAGrid();
        s.getPath(grid, "").stream().forEach(System.out::println);
    }
}
