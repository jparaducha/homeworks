package homework3;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.plexus.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;

public class TestFile {

    private static final Logger LOGGER = LogManager.getLogger(TestFile.class);
    private static final File output = new File("src\\main\\resources\\output");

    public static void main(String[] args) throws IOException {

        File file = FileUtils.getFile(new File("src\\main\\resources\\LoremIpsum.txt"));
        //thisDirectory + "\\LoremIpsum.txt"
        String LoremIpsum = FileUtils.readFileToString(file, "UTF-8").toLowerCase();

        HashSet<String> set = new HashSet<>(Arrays.asList(LoremIpsum.split(" ")));

        LOGGER.info(LoremIpsum.split(" ").length + " words " + set.size() + " unique words");
        // will count same word as a different one if it has a "." at the end;

        countUniqueWords(LoremIpsum);

        File pip = FileUtils.getFile(new File("src\\main\\resources\\Pip.txt"));
        File TextFiles = new File("src\\main\\resources\\TextFiles");

        LOGGER.info("Pip file is older-->" + FileUtils.isFileOlder(pip, Instant.now()));
        LOGGER.info("pip file is newer than lorem ipsum -->" + FileUtils.isFileNewer(pip, file));
        FileUtils.forceMkdir(TextFiles);
        FileUtils.copyToDirectory(pip, TextFiles);

        File pipCopy = FileUtils.getFile(new File("src\\main\\resources\\TextFiles\\Pip.txt"));
        LOGGER.info("Pip file copied to TextFiles -->" + FileUtils.directoryContains(TextFiles, pipCopy));
        LOGGER.info(StringUtils.swapCase("tHIS wILL Be Swapped."));
        LOGGER.info(StringUtils.capitaliseAllWords("red rum, sir, is murder"));
        LOGGER.info(StringUtils.reverse(StringUtils.capitalise("never odd or even.")));
    }

    public static void countUniqueWords(String text) throws IOException {

        int counter = 0;
        //System.out.println(text);
        String[] words = text.split("[$&+,:;=?@#|'<>.-^*()%!]| |[0-9]|\n", 0);

        for (String word : words) {
            //word = word.endsWith(".") || word.endsWith(",") ? StringUtils.chop(word) : word;
            //word = matcher.find() ? word.split("[$&+,:;=?@#|'<>.-^*()%!]| |[0-9]")[0] : word;

            // if the word ends with a "." it is removed;
            if (!StringUtils.isBlank(word) && StringUtils.countMatches(text, word) == 1) {
                //System.out.println("this is unique: " + word);
                counter++;
            }
        }

        FileUtils.writeStringToFile(output, "Unique words in lorem ipsum file: " + counter + " \n", "UTF-8", true);
        LOGGER.info("Unique words : " + counter);
    }
}
