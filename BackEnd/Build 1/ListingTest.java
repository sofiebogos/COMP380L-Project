import java.util.ArrayList;
import java.awt.Image;
import javafx.scene.image.*;

public class ListingTest { // While some variables are ints, ONLY pass strings
    public Account owner;
    private int ID;
    public int year;
    public String make;
    public String model;
    public ArrayList<Image> pictures;
    //public String pictures;
    //public String owner;
    public String color;
    public String condition;
    public int mileage;
    public String titleStatus;
    public String bonusFeatures;
    public String zip;
    public String desc;
    public int price;
    //public String vehicle;
    //public int arraySize = 12; // This is open to expansion if need be

    public ListingTest(Account owner, int ID, int year, String make, String model, ArrayList<Image> pictures, String color, String condition,
            int mileage, String titleStatus, String bonusFeatures, String zip, String desc, int price,
            String vehicle) {
        this.owner = owner;
        this.ID = ID;
        this.year = year;
        this.make = make;
        this.model = model;
        this.pictures = pictures;
        this.owner = owner;
        this.color = color;
        this.condition = condition;
        this.mileage = mileage;
        this.titleStatus = titleStatus;
        this.bonusFeatures = bonusFeatures;
        this.zip = zip;
        this.desc = desc;
        this.price = price;
        ListingManager.addListing(this);
        //this.vehicle = vehicle;
        //this.Export(this.getVars()); // NOT FINAL, just for testing
    }
    
    //simple getter for ID
    public int getID(){
        return ID;
    }

    public void setID(String id2) {
        // id2 = Integer.parseInt(id2);
        // this.ID = id2;
    }

    // public int getArrayLength() {
    //     return arraySize;
    // }

    // public String[] getVars() { // this is the getter for the whole class

    //     String[] vars = new String[arraySize];
    //     vars[0] = Integer.toString(this.ID);
    //     vars[1] = this.pictures;
    //     vars[2] = this.owner;
    //     vars[3] = this.color;
    //     vars[4] = this.condition;
    //     vars[5] = Integer.toString(this.mileage);
    //     vars[6] = this.titleStatus;
    //     vars[7] = this.bonusFeatures;
    //     vars[8] = this.zip;
    //     vars[9] = this.desc;
    //     vars[10] = Integer.toString(this.price);
    //     vars[11] = this.vehicle;
    //     return vars; // Return the array
    // }

    // ---------------------------------------------------
    // Every class will handle it's data and export it out to the write file class
    // so that it can be understood
    // ---------------------------------------------------

    // public void Export(String[] var) {
    //     String superString = "";
    //     String[] listingData = this.getVars();
    //     for (int i = 0; i < getArrayLength(); i++) {
    //         if (i == 0) {
    //             superString = listingData[i];
    //         } else {
    //             superString = superString + ";" + listingData[i];
    //         }
    //     }
    //     WriteFile.appendToFile("listing.txt", superString);
    // }

}