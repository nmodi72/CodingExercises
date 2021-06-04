package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BadgeInOutKarat {
/*
  We want to find which employees aren't using their badge to either enter or exit the building. Given a list of badge records, return two sets - Employees that failed to badge in and another of the employees that failed to badge out.

  We know that at the beginning of the day of badge records, the room is empty and everyone should be gone at the end of the day.

  badge_records = [
    ["Paul" ,  "enter"],
    ["Paul" ,  "enter"],
    ["Curtis" , "enter"],
    ["Paul" , "exit"],
    ["John" , "exit"],
    ["Paul" , "exit"],
    ["Jennifer" , "exit"],
    ["Curtis" , "exit"],
    ["John" , "enter"],
    ["Jennifer" , "enter"],
    ["Curtis" ,  "enter"],
    ["John" , "enter"],
    ["Jennifer" , "enter"],
    ["John" , "exit"],
    ["Curtis" , "exit"],
    ["Jennifer" , "exit"],
  ]

  output:
  [john, paul, jennifer] , [paul]
 */
List<List<String>> enterAndExit(String[][] arr) {
  Map<String, Integer> map = new HashMap();
  Set<String> failedIn = new HashSet();
  Set<String> failedOut = new HashSet();

  for (int i = 0; i < arr.length; i++) {
    String[] record = arr[i];
    String name = record[0];
    boolean isEnter = "enter".equalsIgnoreCase(record[1]) ? true : false;
    int number = map.getOrDefault(name, 0);

    if (isEnter && number == 0)
      map.put(name, 1);
    else if (isEnter && number > 0)
      failedOut.add(name);
    else if (!isEnter && number == 0)
      failedIn.add(name);
    else if (!isEnter && number > 0)
      map.put(name, 0);
  }

  List<List<String>> result = new ArrayList();
  result.add(new ArrayList(failedIn));
  result.add(new ArrayList(failedOut));

  return result;
}
}
