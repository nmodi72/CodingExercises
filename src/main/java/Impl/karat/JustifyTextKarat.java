package main.java.Impl.karat;

import java.util.ArrayList;
import java.util.List;

public class JustifyTextKarat {
    /*
    Write a function to output fully justified text. The output must be an array of lines, and each line must have length equal to "lineLength" parameter - except if it's just one word. See Examples:
    # Example 1 input
    text = [ "Some modern typesetting programs",
              "offer four justification",
              "options" ]
    lineLength = 24

    # Your function, justify(text, lineLength)
    # should return:
           [ "Some  modern typesetting",
             "programs    offer   four",
             "justification    options" ]
    Within the same line, the amount of spaces between words should differ by no more than 1 space:

    Not Allowed: "the      quick brown fox"
    Allowed: "the   quick   brown  fox"

    Example 2:
    # input
    text = [ "The Earth is",
             "the only world",
             "known so far",
             "to harbor life" ]
    lineLength = 18
    # Return:
           [ "The  Earth  is the",
             "only  world  known",
             "so  far  to harbor",
             "life" ]

    Example 3:
    # input
    text = [ "It underscores our responsibility",
             "to deal more kindly with one another" ]
    lineLength = 15
    # Return:
           [ "It  underscores",
             "our",
             "responsibility",
             "to   deal  more",
             "kindly with one",
             "another" ]
     */
    private static final String SPACE_CHAR = " ";
    private static final int SPACE_CHAR_SIZE = 1;
    int numberOfWords;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        numberOfWords = words.length;
        while (start < numberOfWords) {
            int length = words[end++].length();
            while (end < numberOfWords && length + SPACE_CHAR_SIZE + words[end].length() <= maxWidth) {
                length += SPACE_CHAR_SIZE + words[end].length();
                end++;
            }
            result.add(justify(words, start, end, length, maxWidth));
            start = end;
        }
        return result;
    }

    private String justify(String[] words, int start, int end, int length, int lineLength) {
        StringBuilder line = new StringBuilder();
        // if (end < numberOfWords) {
        int numberOfGaps = end - start - 1;
        if (numberOfGaps > 0) {
            int spacesAvailable = lineLength - length + (numberOfGaps * SPACE_CHAR_SIZE);
            int spaces = spacesAvailable / numberOfGaps;
            int spares = spacesAvailable % numberOfGaps;
            while (start < end) {
                line.append(words[start++]);
                if (start < end) {
//                    line.append(SPACE_CHAR.repeat(spaces)); // uncomment this line and add it
                    if (spares > 0) {
                        line.append(' ');
                        spares--;
                    }
                }
            }
        } else {
            line.append(words[start]);
        }
        return line.toString();

    }
}
