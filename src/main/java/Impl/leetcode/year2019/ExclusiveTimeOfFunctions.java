package main.java.Impl.leetcode.year2019;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    /*
    636. Exclusive Time of Functions

    On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.

    We store logs in timestamp order that describe when a function is entered or exited.

    Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended at the end of timestamp 2.

    A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.

    The CPU is single threaded which means that only one function is being executed at a given time unit.

    Return the exclusive time of each function, sorted by their function id.

    Input:
    n = 2
    logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    Output: [3, 4]
     */


    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> st = new Stack<>();

        for (String s : logs) {
            String[] arr = s.split(":");
            Integer val = Integer.parseInt(arr[0]);
            String operation = arr[1];
            Integer index = Integer.parseInt(arr[2]);

            if (operation.equals("start")) {
                if (!st.isEmpty()) {
                    int[] pVal = st.peek();
                    Integer dist = index - pVal[1];
                    result[pVal[0]] += dist;
                }
                st.push(new int[]{val, index});
            } else {
                if (!st.isEmpty()) {
                    int[] pVal = st.pop();
                    if (val == pVal[0]){
                        Integer dist = index - pVal[1] + 1;
                        result[pVal[0]] += dist;
                        if (!st.isEmpty()) {
                            int[]  anotherPVal = st.pop();
                            anotherPVal[1] = index+1;
                            st.push(anotherPVal);
                        }
                    }
                }
            }
        }
        return result;
    }
}
