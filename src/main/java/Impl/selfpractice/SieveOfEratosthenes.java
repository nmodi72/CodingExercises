package main.java.Impl.selfpractice;

/**
 * http://www.algolist.net/Algorithms/Number_theoretic/Sieve_of_Eratosthenes
 */
public class SieveOfEratosthenes {

    public  void runEratosthenesSieve(int upperBound) {
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
        boolean[] isComposite = new boolean[upperBound + 1];
        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                System.out.print(m + " ");
                for (int k = m * m; k <= upperBound; k += m)
                    isComposite[k] = true;
            }
        }

        for (int m = upperBoundSquareRoot; m <= upperBound; m++)
            if (!isComposite[m])
                System.out.print(m + " ");
    }



//    public static void main(String[] args) {
//        runEratosthenesSieve(100);
//        Scanner scan = new Scanner(System.in);
//        double mealCost = scan.nextDouble(); // original meal price
//        int tipPercent = scan.nextInt(); // tip percentage
//        int taxPercent = scan.nextInt(); // tax percentage
//        scan.close();
//
//        // Write your calculation code here.
//        double tipCost = (double) mealCost * ((double) tipPercent / 100);
//        double taxCost = (double) mealCost * ((double) taxPercent / 100);
//
//        // cast the result of the rounding operation to an int and save it as totalCost
//        int totalCost = (int) Math.round(mealCost + tipCost + taxCost);
//        char a[] = {};
//        System.out.println("The total meal cost is" +  " dollars.");
//    }
}
