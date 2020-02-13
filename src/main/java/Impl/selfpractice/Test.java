package main.java.Impl.selfpractice;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nirmodi on 2/2/17.
 */
public class Test {

    public static int findContentChildren(int[] g, int[] s) {
        int result = 0;
        if(g != null && s != null && g.length > 0 && s.length > 0) {
            Arrays.sort(g);
            Arrays.sort(s);
            Queue<Integer> childrens = new LinkedList<Integer>();
            LinkedList<Integer> cookies = new LinkedList<Integer>();
            Queue<Integer> childrensUnserved = new LinkedList<Integer>();
            //adding childrens into queue
            for(int i : g) {
                childrens.add(i);
            }
            //adding cookies into linked list
            for(int i : s) {
                cookies.add(i);
            }
            while((!childrens.isEmpty()) && (!cookies.isEmpty())){
                int id = 0;
                int var1 = cookies.get(id);
                int var2 = childrens.peek();
                if(var1 == var2){
                    cookies.remove(id);
                    childrens.poll();
                    result++;
                } else if(var1 < var2) {
                    cookies.remove(id);
                } else {
                    childrensUnserved.add(childrens.poll());
                }
            }
        }
        return result;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
            if(g[i]<=s[j]) i++;
        }
        return i;
    }

    public static void main(String[] args) throws IOException {
        int[] arr1 = {250, 250, 490,328,149,495,325,314,360,333,418,430,458};
        int[] arr2 = { 5, 6, 250,490,328,149,495,325,314,360,333,418,430,458};

        int[] v1 = {2,16,32,34,34,41,45,51,56,57,73,81,95,96,98,102,104,106,106,108,113,118,119,120,131,
                134,142,143,145,145,158,160,174,205,206,209,214,216,218,219,220,231,234,253,262,268,271,
                271,275,279,281,284,304,312,322,323,324,343,344,345,346,355,364,366,368,370,373,375,377,
                379,385,406,406,416,422,425,431,433,437,438,439,442,444,446,446,450,461,461,463,466,466,
                479,481,482,484,491,496,514,515};

        int[] v0 = {2,45,56,95,104,106,106,113,119,131,
                134,142,143,145,145,158,160,174,205,206,209,214,216,218,219,220,231,234,253,262,268,271,
                271,275,279,281,284,304,312,322,323,324,343,344,345,346,355,364,366,368,370,373,375,377,
                379,385,406,406,416,422,425,431,433,437,438,439,442,444,446,446,450,461,461,463,466,466,
                479,481,482,484,491,496,514,515};

        int[] v2 = {2,3,4,6,6,7,10,13,18,21,23,23,23,27,30,30,33,36,39,39,40,43,45,46,56,58,59,63,63,66,
                68,69,71,72,76,76,77,77,78,79,82,84,84,85,91,91,95,95,95,104,106,106,112,113,119,126,130,
                130,131,140,142,142,143,147,149,151,151,151,155,155,159,159,162,163,164,169,170,171,171,173,
                178,179,185,194,198,198,199,202,221,226,232,233,238,241,243,244,245,249,251,251,251,251,254,
                256,262,274,276,276,276,283,283,284,285,289,291,292,293,293,295,295,296,297,300,307,309,310,
                311,312,315,319,321,324,325,329,330,330,330,333,334,334,334,337,337,339,343,345,347,348,349,
                352,353,354,354,356,358,358,360,361,366,368,370,373,376,377,380,382,383,388,396,399,399,400,
                400,401,403,406,414,416,416,417,417,418,418,419,420,422,424,425,427,428,428,429,430,430,436,
                437,438,440,440,444,445,446,446,447,447,451,458,461,466,466,469,479,479,481,483,485,494,495,
                497,499,501,505,505,507,511,511,512,513,515,516,519,519,522,522,524,524};


        System.out.print(findContentChildren(arr1, arr2));


    }
}
