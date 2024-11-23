import java.util.ArrayList;
import java.awt.Image;
import javafx.scene.image.*;

public class ListingTest { // While some variables are ints, ONLY pass strings
    private Account owner;
    public int ID;
    private String year, make, model, color, condition, mileage;
    private String titleStatus, bonusFeatures, zip, desc, price;
    private ArrayList<Image> pictures;
    //private String make;
    //public String pictures;
    //public String owner;
    //public String vehicle;
    //private int arraySize = 12; // This is open to expansion if need be

    public ListingTest(Account owner, int  ID, String year, String make,
                        String model, String color, String mileage,
                        String condition, String titleStatus, String zip,
                        String price, String desc                           ) {

        this.owner = owner;
        this.ID = ID;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.condition = condition;
        this.titleStatus = titleStatus;
        this.zip = zip;
        this.price = price;
        this.desc = desc;
        this.pictures = pictures;
        ListingManager.addListing(this); //Store in the in the ArrayList  
        this.Export(getVars()); //Export as txt file
        //this.vehicle = vehicle;
        //this.Export(this.getVars()); // NOT FINAL, just for testing
    }
    
    //simple getter for ID
    public int getID(){
        return ID;
    }

    //Getter for list of pictures
    public ArrayList getPictures(){
        return pictures;
    }

    public void setID(String id2) {
        // id2 = Integer.parseInt(id2);
        // this.ID = id2;
    }


    // this is the getter for the passed along Strings of the listing Object
    public String[] getVars() { 
        return new String[]{year, make, model, color, mileage, 
                            condition, titleStatus, zip, desc }; 
        // Return as array
    }

    // ---------------------------------------------------
    // Every class will handle it's data and export it out to the write file class
    // so that it can be understood
    // ---------------------------------------------------

    public void Export(String[] var) {
        String superString = "";
        String[] listingData = getVars();
        for (int i = 0; i < getVars().length; i++) {
            if (i == 0) {
                superString = listingData[i];
            } else {
                superString = superString + ";" + listingData[i];
            }
        }
        WriteFile.appendToFile("listing.txt", superString);
    }

}