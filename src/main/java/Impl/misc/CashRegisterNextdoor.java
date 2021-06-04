package main.java.Impl.misc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CashRegisterNextdoor {
    static Map<String, Double> data;
    static Set<String> result;

    public static void main(String[] args) {
        data = new LinkedHashMap<>();
        data.put("ONE HUNDRED", 100.00);
        data.put("FIFTY", 50.00);
        data.put("TWENTY", 20.00);
        data.put("TEN", 10.00);
        data.put("FIVE", 5.00);
        data.put("TWO", 2.00);
        data.put("ONE", 1.00);
        data.put("HALF DOLLAR", 0.50);
        data.put("QUARTER", 0.25);
        data.put("DIME", 0.10);
        data.put("NICKEL", 0.05);
        data.put("PENNY", 0.01);

        Set<String> result = findDenomination(1);
        for(String s : result) System.out.println(s);
    }

    public static Set<String> findDenomination(double amt){
        result = new HashSet<>();
        for(String key : data.keySet()){
            amt = traverse(amt, key, data.get(key));
        }
        return result;
    }

    private static double traverse(double amt, String denomNote, double denom){
        if(amt < denom) return amt;
        int notes = (int)(amt / denom);
        amt = (amt % denom);
        result.add(notes + ":"+ denomNote);
        BigDecimal bd = new BigDecimal(amt).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
