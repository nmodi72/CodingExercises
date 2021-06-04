package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindNodesWithZeroAndOneParents {
    /*
    Given a set of relationship between parent and child , create two lists where one presents children with one parent while another one where children with no known parents.
    [1,3][2,3][3,4][4,5][6,5] --> would be the answer in this case {4} & {1,2,6}
     */
    static List<Set<Integer>> findNodesWithZeroAndOneParents(int parentChildPairs[][]) {
        HashMap<Integer, Integer> mapWithOne = new HashMap<Integer, Integer>();
        Set<Integer> listOfZeros = new HashSet();
        Set<Integer> listOfOnes = new HashSet();
        List<Set<Integer>> result = new ArrayList<Set<Integer>>();
        for (int i = 0; i < parentChildPairs.length; i++) {
            if (!mapWithOne.containsKey(parentChildPairs[i][1])) {
                mapWithOne.put(parentChildPairs[i][1], 1);
            } else {
                mapWithOne.put(parentChildPairs[i][1], mapWithOne.get(parentChildPairs[i][1]) + 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : mapWithOne.entrySet()) {
            if (entry.getValue() == 1 && !listOfOnes.contains(entry.getKey())) {
                listOfOnes.add(entry.getKey());
            }
        }

        for (int i = 0; i < parentChildPairs.length; i++) {
            if (!mapWithOne.containsKey(parentChildPairs[i][0]) && !listOfZeros.contains(parentChildPairs[i][0])) {
                listOfZeros.add(parentChildPairs[i][0]);
            }
        }
        result.add(listOfZeros);
        result.add(listOfOnes);

        return result;
    }

}
