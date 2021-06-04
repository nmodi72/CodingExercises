package main.java.Impl.leetcode.year2019;

import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharactersII {
    /*
    158. Read N Characters Given Read4 II - Call multiple times

    Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.



    Method read4:

    The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.

    The return value is the number of actual characters read.

    Note that read4() has its own file pointer, much like FILE *fp in C.

    Definition of read4:

        Parameter:  char[] buf
        Returns:    int

    Note: buf[] is destination not source, the results from read4 will be copied to buf[]
    Below is a high level example of how read4 works:

    File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
    char[] buf = new char[4]; // Create buffer with enough space to store characters
    read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
    read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
    read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
     */
    Queue<Character> q = new LinkedList<>();
    public int read(char[] buf, int n) {
        Integer result = 0;
        if (n == 0) return result;
        char[] buffer = new char[4];
        Integer index = 0;
        while (!q.isEmpty() && index < n) {
            buf[index++] = q.poll();
            result++;
        }
        if (result == n) return result;

        Integer itemsToPoll = n - result;
        while (itemsToPoll > 0) {
            int subCount = 0; // read4(buffer);
            if (subCount == 0) break;
            itemsToPoll -= subCount;
            for (int i = 0; i < subCount; i++) {
                if (index < n)  {
                    buf[index++] = buffer[i];
                    result++;
                } else
                    q.add(buffer[i]);
            }
        }
        return result;
    }
}
