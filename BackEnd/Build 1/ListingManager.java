import java.util.ArrayList;
import java.util.ListIterator;

public class ListingManager {

    //holds all listings when app is running 
    public static ArrayList<ListingTest> listings = new ArrayList<>();
    public static ListIterator<ListingTest> listingIterator;

    public static void addListing(ListingTest tempList){ //adds new listing to end of the arraylist
        listings.add(tempList);
        listingIterator = listings.listIterator();
    }

    //Getter for a listing in the ArrayList.
    //Finds the specific listing by using the listing ID as a parameter
    public ListingTest getListing(int id){
        listingIterator = listings.listIterator();
        while (listingIterator.hasNext()){
            ListingTest tempList = listingIterator.next();
            if (tempList.getID() == id){
                return tempList;
            }
        }
        return null;
    }
}
