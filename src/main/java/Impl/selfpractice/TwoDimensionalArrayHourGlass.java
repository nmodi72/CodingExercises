package main.java.Impl.selfpractice;

/**
 * Created by nirmodi on 2/9/17.
 */
public class TwoDimensionalArrayHourGlass {

    public static int getWeight(int i, int j, int[][] arr){
        int result = 0;
        for(int a = i; a < i + 3; a++){
            for(int b = j; b < j + 3; b++){
                if((a - i) == (b - j)) {
                    result = result + arr[a][b];
                } else if((a == i) || (a == i + 2)){
                    result = result + arr[a][b];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] arr = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {1, 1, 1, -12},
                        {13, 14, 15, 16}};
        System.out.print(getWeight(1, 1, arr));
    }


}
