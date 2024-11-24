import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static void main(String[] args) {
        ReadListing("listing.txt");
    }

    // to do: this function should only take a file name and call a function
    // specific to that file

    public static void ReadListing(String filename) { // This function can only read listings, but should serve as a
                                                      // template

        List<Listing> listings = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != "") {
                    System.out.println(data);
                    String[] parts = data.split(";");
                    listings.add(
                            new Listing(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7],
                                    parts[8], parts[9], parts[10], parts[11]));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean Compare(String toCompare, String filename) {
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if ((Objects.equals(data, toCompare)) == true) {
                    myReader.close();
                    return true;
                }
            }
            myReader.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }
}
