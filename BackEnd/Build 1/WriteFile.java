
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class WriteFile {

    // --------------------------------------------------------------------------------------------------------
    // Overwrite File will completely over write any exisiting file named the same.
    // Use this only if you want to clear bad data!
    // --------------------------------------------------------------------------------------------------------

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

    // --------------------------------------------------------------------------------------------------------
    // This just appends a new line to whatever is in the file
    // It uses compare to not add duplicates
    // --------------------------------------------------------------------------------------------------------
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

    public static void main(String[] args) {

    }
}
