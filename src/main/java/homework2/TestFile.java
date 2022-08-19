package homework2;

import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class TestFile {

    static String a = System.getProperty("java.class.path");
    static int index = a.indexOf("homeworks");

    public static void main(String[] args) throws IOException {

        File file = FileUtils.getFile((a.substring(0, index) + "homeworks\\src\\main\\java\\homework2\\LoremIpsum.txt"));
        String LoremIpsum = FileUtils.readFileToString(file, "UTF-8").toLowerCase();

        HashSet<String> set = new HashSet<>(Arrays.asList(LoremIpsum.split(" ")));

        System.out.println(LoremIpsum.split(" ").length + " words " + set.size() + " unique words");
        // will count same word as a different one if it has a "." at the end;

        CountUniqueWords(LoremIpsum);
    }

    public static void CountUniqueWords(String text) {

        int counter = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            word = word.endsWith(".") ? StringUtils.chop(word) : word;
            // if the word ends with a "." it is removed;
            if (StringUtils.countMatches(text, word) == 1) {
                counter++;
            }
        }
        System.out.println("Unique words : " + counter);
    }
}
