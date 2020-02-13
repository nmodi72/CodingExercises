package main.java.Impl.CS_Dojo;

public class FindAllSubsetOfSet {

    /**
     * URL: https://www.youtube.com/watch?v=bGC2fNALbNU
     */
    public void findAllSubset(Integer[] input) {
        Integer[] subset = new Integer[input.length];
        helper(input, subset, 0);
    }

    private void helper(Integer[] input, Integer[] subset, int i) {
        if (i == input.length) {
            for (Integer value : subset) {
                System.out.print(value == null ? "*" : value);
            }
            System.out.println("");
        } else {
            subset[i] = null;
            helper(input, subset, i+1);
            subset[i] = input[i];
            helper(input, subset, i+1);
        }
    }
}
