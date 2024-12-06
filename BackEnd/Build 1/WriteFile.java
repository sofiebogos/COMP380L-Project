
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class WriteFile {

    /**
     * This will overwrite the ENTIRE file that it is saving to
     * should only be used to clear out bad data
     * takes @param filename which is the file and @param content which is what's to
     * be saved
     */

    public static void overWriteFile(String filename, String content) {
        Path path = Paths.get(filename);
        try {
            content = content + "\n";
            Files.write(path, content.getBytes());
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Appends a line to the end of a save file
     * USes the compare function from readfile to make sure that it isn't adding the
     * same line over and over and over
     * takes @param filename which is the file and @param content which is what's to
     * be saved
     */

    public static void appendToFile(String filename, String content) {
        Path path = Paths.get(filename);

        try {
            if (ReadFile.Compare(content, "listing.txt") != true) {
                content = content + "\n";
                Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }
}
