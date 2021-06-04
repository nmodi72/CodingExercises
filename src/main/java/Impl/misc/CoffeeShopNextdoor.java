package main.java.Impl.misc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CoffeeShopNextdoor {

    /**
     Your neighborhood coffee shop runs these deals on Nextdoor:
     1 coffee for $2 (coupon 'A')
     3 coffees for $5 (coupon 'B')
     7 coffees for $9 (coupon 'C')

     Write a function to compute the minimum cost to order given the number of coffees for a party.

     Examples:
     1. For 3 coffees, the mimumim cost would be $5 (B) --> (B - $5) or (3A - $6)
     2. For 5 coffees, the minimum cost would be $9 (B + 2A) --> (B + 2A - $9) or (5A - $10)
     3. For 13 coffees, the minimum cost would be $18 (2C) --> (2C - $18) or (13A - $26) or (4B + A - $22)

     Tests:
     1. For 35 coffees, the minimum cost is $45
     2. For 46 coffees, the minimum cost is $61
     3. For 149 coffees, the minimum cost is $193
     4. For 678 coffees, the minimum cost is $873
     5. For 1245 coffees, the minimum cost is $1602
     */

    Map<Integer, Integer> data;  // coffee - price
    Set<Integer> visited;
    int dollarSpent = Integer.MAX_VALUE;

    CoffeeShopNextdoor() {
        visited = new HashSet<Integer>();
        data = new HashMap<Integer, Integer>();
        data.put(7 ,9);
        data.put(3, 5);
        data.put(1, 2);
    }
    public int getMinCost(int noOfCoffees) {
        return calculateMin(noOfCoffees, 0);
    }

    private int calculateMin(int coffee, int price) {
        if(coffee <= 0) {
            return price;
        }
        int result = Integer.MAX_VALUE;
        for(Integer key : data.keySet()){
            result = Math.min(result, calculateMin(coffee - key, price + data.get(key)));
        }
        return result;
    }

    public static void main(String[] args) {
        CoffeeShopNextdoor c = new CoffeeShopNextdoor();
        System.out.println("3 coffee: " + c.getMinCost(149));
    }
}
