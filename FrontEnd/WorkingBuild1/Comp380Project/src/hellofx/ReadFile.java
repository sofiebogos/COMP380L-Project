package hellofx;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import javafx.scene.image.Image;

/**
 * @author @version
 *         The interface to the text files that store data
 *         any time something needs to be read from a file this class is called
 */

public class ReadFile {
    //public static List<car> carList = new ArrayList<>();
    //public static ArrayList<Listing> listingList = new ArrayList<>();
    public static ArrayList<Account> accountList = new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        Read("listing.txt");
    }

    /**
     * Read gets passed a @param filename which it uses to call the respective
     * function to read the file
     * each file needs its own function because they have different array lengths
     */

    public static void Read(String filename) {
        // if (filename == "car.txt") {
        //     ReadCar();
        // }
        if (filename == "listing.txt") {
            ReadListing();
        }
        if (filename == "account.txt") {
            ReadAccount();
        }

    }

    /**
     * Reads the car.txt file
     * Splits it into an array, then passes the array to the constructor
     */

    // public static void ReadCar() {
    //     String filename = "car.txt";

    //     try {
    //         File file = new File(filename);
    //         Scanner myReader = new Scanner(file);
    //         while (myReader.hasNextLine()) {
    //             String data = myReader.nextLine();
    //             if (data != "") {
    //                 System.out.println(data);
    //                 String[] parts = data.split(";");
    //                 carList.add(new car(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6],
    //                         parts[7], parts[8], parts[9]));
    //             }
    //         }
    //         myReader.close();
    //     } catch (FileNotFoundException e) {
    //         System.out.println("An error occurred.");
    //         e.printStackTrace();
    //     }

    // }

    /**
     * Reads the account.txt file
     * Splits it into an array, then passes the array to the constructor
     */

    public static void ReadAccount() {
        String filename = "account.txt";
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != "") {
                    System.out.println(data);
                    String[] parts = data.split(";");
                    accountList.add(
                            new Account(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7],
                                    parts[8], parts[9], parts[10], parts[11], parts[12], parts[13]));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Reads the listing.txt file
     * Splits it into an array, then passes the array to the constructor
     */

    public static void addDefaultListings(Account account) { // This function can only read listings, but should serve as a template
        try {
            int i = 0;
            //File file = new File("TextFiles\\Listings.txt");
            Scanner myReader = new Scanner(new File("F:\\Comp380Project\\src\\TextFiles\\Listings.txt"));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data != "") {
                    //System.out.println(data);
                    String[] parts = data.split(";");
                    new Listing(account, parts[0], parts[1], parts[2], 
                                parts[3], parts[4], parts[5], parts[6], 
                                parts[7], parts[8], parts[9], ListingManager.getDefaultpics(i));
                    i++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Compare takes in two strings
     * 
     * @param toCompare the string to look for
     * @param filename  name of the file to search through
     *                  goes through the file looking to see if it the string is
     *                  inside it
     * @return true if string is in file, false if not
     */

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

    /**
     * @param toCompare takes in a string to compare, @param filename takes in the
     *                  name of the file
     *                  goes through the file looking to see if a line has part of a
     *                  string inside it, if it is then return the whole line
     * @return 0 if not found, @return the string if it is
     */

    public static String FindAndReturn(String toCompare, String filename) { // ONLY CHECKS FOR A PARTIAL. IF HANDED BAD
                                                                            // DATA WILL RETURN BAD RESULTS
        try {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if ((toCompare.toLowerCase().contains(data)) == true) {
                    myReader.close();
                    return toCompare;
                }
            }
            myReader.close();
            return "0";
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "0";
    }
}
