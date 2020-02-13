package main.java.Impl.selfpractice;

/**
 * Created by Nirav.Modi on 5/2/2017.
 */
public class FindAllAnagrams {

    public static void findAllAnagrams(String prefix, String str) {
        int n = str.length();
        if(n == 0) System.out.print(prefix + " ");
        else {
            for (int i = 0; i < n; i++) {
                findAllAnagrams(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
            }
        }
    }

    public static void main(String[] str){
        findAllAnagrams("", "abc");
    }

}
