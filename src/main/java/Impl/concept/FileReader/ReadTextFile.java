package main.java.Impl.concept.FileReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadTextFile {

    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        FileReader fr = new FileReader("/Users/nmodi/Desktop/kanji.txt");
        HashMap<Character, Character> hm = new HashMap<>();
        List<String> list = new ArrayList<String>();
        List<String> frenchList = new ArrayList<String>();
        List<String> englishList = new ArrayList<String>();
        File file = new File("/Users/nmodi/Desktop/kanji.txt");
        if(file.exists()){
            try {
                list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if(list.isEmpty())
                return;
        }
        for(String line : list){
            String [] res = line.split(" => ");
            frenchList.add(res[0]);
            englishList.add(res[1]);
            System.out.println("\"" + res[1] + " => " + res[0] + "\",");
        }
    }
}
