package main.java.Impl.leetcode.year2017;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * This is the leetcode problem: # 335
 * Self Crossing
 *
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north,
 * then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on.
 * In other words, after each move your direction changes counter-clockwise.
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 *
 * Example:
 * Given x = [2, 1, 1, 2]
 * Return true (self crossing)
 */
public class SelfCrossing {

    public static boolean isSelfCrossing(int[] x) {
        if(x != null && x.length == 0){
            return false;
        }
        int up = 0;
        int left = 0;
        int down = 0;
        int right = 0;

        for(int i = 0; i < x.length; i++){
            if(i % 4 == 0) {
                up += x[i];
            } else if(i % 4 == 1) {
                left += x[i];
            } else if(i % 4 == 2) {
                down += x[i];
            } else if(i % 4 == 3) {
                right += x[i];
            }
        }

        return (up >= down && right >= left);
    }

    private static String ENCRYPTION_KEY = "Bar12345Bar12345";

    public static String encryptPassword(String plainPassword) throws Exception{
        // Create key and cipher
        Key aesKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        // encrypt the text
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return new String(cipher.doFinal(plainPassword.getBytes()));
    }

    public static String decryptPassword(String passwordHash) throws Exception{
        Key aesKey = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        byte[] encrypted = cipher.doFinal(passwordHash.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return new String(cipher.doFinal(encrypted));
    }
    public static void main(String[] args) throws Exception{
        String a = encryptPassword("Test");
        System.out.print(a);

        System.out.print(decryptPassword(a));
    }
}
