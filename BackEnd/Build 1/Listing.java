public class Listing { // While some variables are ints, ONLY pass strings
    private int ID;
    private String pictures;
    private String owner;
    private String color;
    private String condition;
    private int mileage;
    private String titleStatus;
    private String bonusFeatures;
    private int zip;
    private String desc;
    private int arraySize = 10; // This is open to expansion if need be

    public Listing(String id, String pictures, String owner, String color, String condition,
            String mileage, String titleStatus, String bonusFeatures, String zip, String desc) {
        this.ID = Integer.parseInt(id);
        this.pictures = pictures;
        this.owner = owner;
        this.color = color;
        this.condition = condition;
        this.mileage = Integer.parseInt(mileage);
        this.titleStatus = titleStatus;
        this.bonusFeatures = bonusFeatures;
        this.zip = Integer.parseInt(zip);
        this.desc = desc;
        this.Export(this.getVars()); // NOT FINAL, just for testing
    }

    public void setID(String id2) {
        id2 = Integer.parseInt(id2);
        this.ID = id2;
    }

    public int getArrayLength() {
        return arraySize;
    }

    public String[] getVars() { // this is the getter for the whole class

        String[] vars = new String[arraySize];
        vars[0] = Integer.toString(this.ID);
        vars[1] = this.pictures;
        vars[2] = this.owner;
        vars[3] = this.color;
        vars[4] = this.condition;
        vars[5] = Integer.toString(this.mileage);
        vars[6] = this.titleStatus;
        vars[7] = this.bonusFeatures;
        vars[8] = Integer.toString(this.zip);
        vars[9] = this.desc;
        return vars; // Return the array
    }

    // ---------------------------------------------------
    // Every class will handle it's data and export it out to the write file class
    // so that it can be understood
    // ---------------------------------------------------

    public void Export(String[] var) {
        String superString = "";
        String[] listingData = this.getVars();
        for (int i = 0; i < getArrayLength(); i++) {
            if (i == 0) {
                superString = listingData[i];
            } else {
                superString = superString + ";" + listingData[i];
            }
        }
        WriteFile.writeToFile("listing.txt", superString);
    }

}
