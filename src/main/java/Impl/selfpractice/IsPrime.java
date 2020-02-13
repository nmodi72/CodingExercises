package main.java.Impl.selfpractice;

import java.math.BigDecimal;

/**
 * Created by nirmodi on 1/23/17.
 */
public class IsPrime {

    public static boolean isPrime(int num) {
        if(num < 2)
            return false;
        if(num == 2)
            return true;
        if(num % 2 == 0)
            return false;
        for(int i = 3; i * i <= num; i += 2)
            if(num % i == 0)
                return false;
        return true;
    }

    public static int primes(int x, int i)
    {
        if(i==1)
            return 1;
        if(x%i==0)
            return 0;
        else
            return primes(x, i-1);
    }

    public static void printPrime(int value) {
        for (int i = 0; i < value; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
    }

    public static void main(String args[]) throws Exception {

        BigDecimal bg =  BigDecimal.ZERO;
        BigDecimal bg1 =  BigDecimal.valueOf(2);

        bg = bg.add(bg1);

        System.out.println("Result: " + bg);

//        printPrime(value);
    }
}
