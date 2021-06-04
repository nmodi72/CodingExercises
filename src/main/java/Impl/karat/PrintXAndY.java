package main.java.Impl.karat;

import java.util.HashSet;
import java.util.Set;

public class PrintXAndY {
/*
  Print X and Y in such a way so that
 */

  static Set<String> result;

  public static void printXAndY(int n){
    if (n <= 0) return;
    result = new HashSet<>();
    traverse("X", n, 1, 0);
    for(String s : result) System.out.println(s);
  }

  private static void traverse(String str, int n, int x, int y){
    if(n == x && x == y) {
      result.add(str);
      return;
    }
    if(x < n) {
      traverse(str + "X", n, x + 1, y);
    }
    if(y < x) {
      traverse(str + "Y", n, x, y+1);
    }
  }




  public static void main(String[] args) {
    PrintXAndY.printXAndY(3);
  }

}
