package main.java.Impl.leetcode.year2017;

import java.util.HashMap;

/**
 * This is the leetcode problem: #383
 * Ransom Note
 *
 * Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the
 * ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   
 *
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * Example:
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> directoryMap = new HashMap<>();
        for (char magazineCharacter : magazine.toCharArray()) {
            if (directoryMap.containsKey(magazineCharacter)) {
                directoryMap.put(magazineCharacter, directoryMap.get(magazineCharacter) + 1);
            } else {
                directoryMap.put(magazineCharacter, 1);
            }
        }

        for (char noteCharacter : ransomNote.toCharArray()) {
            if (directoryMap.containsKey(noteCharacter)) {
                if(directoryMap.get(noteCharacter) > 0) {
                    directoryMap.put(noteCharacter, directoryMap.get(noteCharacter) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 17 ms - 87.77 % beat others
    public boolean canConstructMoreEfficient(String ransomNote, String magazine) {
        int[] table = new int[128];
        for (char c : magazine.toCharArray())   table[c]++;
        for (char c : ransomNote.toCharArray())
            if (--table[c] < 0) return false;
        return true;

    }


    public static boolean compareTwoString(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        int[] table = new int[128];
        for (char c : str1.toCharArray())   table[c]++;
        for (char c : str2.toCharArray())
            if (--table[c] < 0) return false;
        return true;
    }
}
