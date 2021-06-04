package main.java.Impl.leetcode.year2019;

public class CoinChange {

    /*
    322. Coin Change
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

    Example 1:

    Input: coins = [1, 2, 5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1
    Example 2:

    Input: coins = [2], amount = 3
    Output: -1
    Note:
    You may assume that you have an infinite number of each kind of coin.
     */
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return 0;
        return countSum(coins,amount, 0, new int[amount]);
    }

    private int countSum(int[] coins, int sum, int id, int[] data) {
        if(sum == 0) return 0;
        if(sum < 0) return -1;
        if(data[sum-1] != 0) return data[sum-1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int remainingSum = sum-coins[i];
            int ct = countSum(coins, remainingSum, i, data);
            if(ct >= 0 && ct < min) min = ++ct;
        }
        data[sum-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return data[sum-1];
    }
}
