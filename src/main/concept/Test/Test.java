package main.concept.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;
import javafx.util.Pair;

/**
 * Created by nirmodi on 2/7/17.
 */
public class Test {

    static int minimumSwaps(int[] popularity) {
        if(popularity != null && popularity[0] > 0) {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 1; i < popularity.length; i ++) {
                if(popularity[i] > maxValue) {
                    maxValue = popularity[i];
                }
            }
            int id = 1;
            int count = 0;
            while (id <= popularity[0] -1) {
                for (int i = id; i < popularity.length; i++) {
                    if (id != i) {
                        if (maxValue == popularity[i]) {
                            int temp = popularity[id];
                            popularity[id] = popularity[i];
                            popularity[i] = temp;
                            count++;
                            id++;
                            maxValue--;
                        } else if(maxValue > popularity[i]) {

                        }
                    }
                }
            }
        return count;
        }
        return 0;
    }

    public static int minSwaps(int[] popularity)
    {
        Set<Integer> table = new LinkedHashSet<>();
        for (int i : popularity) {
            if(table.contains(i)) {
                table.remove(i);
            }
            table.add(i);
        }
        int[] result = new int[table.size()];
        int var = 0;
        for (int i: table) {
            result[var++] = i;
        }
        int n = result.length;
        ArrayList<Pair<Integer, Integer>> arrpos =
                new ArrayList <Pair <Integer, Integer> > ();
        for (int i = 0; i < n; i++)
            arrpos.add(new Pair <Integer, Integer> (result[i], i));
        arrpos.sort(new Comparator<Pair<Integer, Integer>>()
        {
            @Override
            public int compare(Pair<Integer, Integer> o1,
                               Pair<Integer, Integer> o2)
            {
                if (o1.getValue() > o2.getValue())
                    return -1;
                else if (o1.getValue().equals(o2.getValue()))
                    return 0;
                else
                    return 1;
            }
        });
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            if (vis[i] || arrpos.get(i).getValue() == i)
                continue;
            int iter = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;
                j = arrpos.get(j).getValue();
                iter++;
            }
            ans += (iter - 1);
        }
        return ans;
    }


    static long countMoves(int[] numbers) {
        if(numbers != null) {
            int a = numbers[1];
            int maxId = 0;
            int size = 0;
            for (int i = 1; i < numbers.length; i++) {
                if(a == numbers[i]) {
                    size++;
                } else if(a < numbers[i]){
                    a = numbers[i];
                    maxId = i;
                }
            }
            if(size == numbers.length - 1) {
                return 0L;
            }
            int max = 0;
            for (int i = 1; i < numbers.length; i++) {
                if(maxId != i) {
                    numbers[i] = numbers[i] + 1;
                }
            }
            return countMoves(numbers) + 1;
        }
        return 0L;



    }

    public static String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    public static void main(String[] args) {
//        int[] arr = {5, 3, 1, 2, 4};
//        int[] arr = {  3, 4, 1, 5};
        String[] arr = {"Hello", "DUHADUAH ", "SNALHJUAEH", "AUHSQUHS"};
        String[] result = findWords(arr);
        System.out.print(result.clone());
    }
}
