package main.java.Impl.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nmodi on 9/26/18.
 */
public class ExtractDataFromTextFile {

    private static final String FILENAME = "/Users/nmodi/Desktop/national_channelids.txt";

    public static void main(String[] args) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.contains("channelId") && !sCurrentLine.contains("tmsChannelId")) {
                    String trimmedChannelId = sCurrentLine.trim()
                            .replace("channelId: ", "")
                            .replace(",", "");
                    System.out.print(trimmedChannelId + " OR ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
