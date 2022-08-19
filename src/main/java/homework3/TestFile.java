package homework3;

import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

public class TestFile {

    public static void main(String[] args) throws IOException {

        File file = FileUtils.getFile(new File("src\\main\\java\\homework3\\LoremIpsum.txt"));
        //thisDirectory + "\\LoremIpsum.txt"
        String LoremIpsum = FileUtils.readFileToString(file, "UTF-8").toLowerCase();

        HashSet<String> set = new HashSet<>(Arrays.asList(LoremIpsum.split(" ")));

        System.out.println(LoremIpsum.split(" ").length + " words " + set.size() + " unique words");
        // will count same word as a different one if it has a "." at the end;

        CountUniqueWords(LoremIpsum);

        File pip = FileUtils.getFile(new File("src\\main\\java\\homework3\\Pip.txt"));
        File TextFiles = new File("src\\main\\java\\homework3\\TextFiles");

        System.out.println("Pip file is older-->" + FileUtils.isFileOlder(pip, Instant.now()));
        System.out.println("pip file is newer than lorem ipsum -->" + FileUtils.isFileNewer(pip, file));
        FileUtils.forceMkdir(TextFiles);
        FileUtils.copyToDirectory(pip, TextFiles);

        File pipCopy = FileUtils.getFile(new File("src\\main\\java\\homework3\\TextFiles\\Pip.txt"));
        System.out.println("Pip file copied to TextFiles -->" + FileUtils.directoryContains(TextFiles, pipCopy));
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
