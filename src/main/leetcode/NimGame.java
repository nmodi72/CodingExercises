package main.leetcode;

/**
 * This is the leetcode problem: # 292
 * Nim Game
 *
 * You are playing the following Nim Game with your friend:
 * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game.
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 *
 * For example, if there are 4 stones in the heap, then you will never win the game:
 * no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 */
public class NimGame {

    // 3 ms
    public boolean canWinNim(int n) {
        if(n <= 0){
            return false;
        }
        while (n > 0) {
            if (n <= 3) {
                return true;
            }
            // user makes move
            n = n - 1;
            if (n <= 3) {
                return false;
            }
            // otherwise opponent makes move
            n = n - 3;
        }
        return false;
    }
    // runtimes is  0 ms
    public boolean canWinNimBetterSolution(int n) {
        return n % 4 > 0;
    }
}
