package hellofx;

import java.util.ArrayList;
import java.util.ListIterator;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;

public class ListingManager {

    //holds all listings when app is running 
    private static ArrayList<Listing> listings = new ArrayList<>();
    private static ListIterator<Listing> listingIterator;
    private static ArrayList<ArrayList<Image>> defaultCarPics = new ArrayList<>();

    public static void addListing(Listing tempList){ //adds new listing to end of the arraylist
        listings.add(tempList);
        listingIterator = listings.listIterator();
    }

    //Getter for a listing in the ArrayList.
    //Finds the specific listing by using the listing ID as a parameter
    public static Listing getListing(int id){
        listingIterator = listings.listIterator();
        while (listingIterator.hasNext()){
            Listing tempList = listingIterator.next();
            if (tempList.getID() == id){
                return tempList;
            }
            else{}
        }
        return null;
    }

    public static ArrayList<Image> getEachArrayPics(String[] picLocations){
        try{
        ArrayList<Image> currArrayList= new ArrayList<>();
        FileInputStream inputStream;

        for (String currentPic : picLocations){
            inputStream = new FileInputStream(currentPic);
            Image currentImage = new Image(inputStream);
            currArrayList.add(currentImage);

            if (currentImage.isError()) {
                System.out.println(picLocations.length);
                System.err.println(currentPic);
                System.out.println("Image failed to load. " + currentImage.getException());
            }
        }
        return currArrayList;
        }
        catch(Exception e){
            System.err.println("Did not leave method");
            return null;    
        }
    }

    public static void addDefaultPics(){
        try {
            File file = new File("F:\\Comp380Project\\src\\TextFiles\\PicsList.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.next();
                String[] picLocations = line.split(";");
                defaultCarPics.add(getEachArrayPics(picLocations));               
            } 
        } 
        catch (FileNotFoundException e) {
            System.err.println("issue locating a file");
            e.printStackTrace();
        }
    }

    public static ArrayList<Image> getDefaultpics(int i){
        return defaultCarPics.get(i);
    }
    
    public static ArrayList<Listing> getAllListings(){
        return listings;
    }

    public static ArrayList<Listing> searchCars(String userSearch){
        ArrayList<Listing> returnList = new ArrayList<>();

        for (Listing listing: listings){
            if (listing.getMake().equalsIgnoreCase(userSearch)){
                returnList.add(listing);
            }
            else if (listing.getModel().equalsIgnoreCase(userSearch)){
                returnList.add(listing);
            }
            else if (listing.getYear().equalsIgnoreCase(userSearch)){
                returnList.add(listing);
            }
            else{}
        }
        return returnList;
    }
}
