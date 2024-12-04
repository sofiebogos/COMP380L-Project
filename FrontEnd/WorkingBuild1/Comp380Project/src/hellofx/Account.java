package hellofx;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Account{
    private String firstName, lastName, email, password;
    private String month, day, year; 
    private String city, state, address, EXPDate, zipcode;
    private String cardNumber, CVC;
    public int listingCount = 0;
    private ArrayList<Integer> listings = new ArrayList<>();

    public Account(String firstName, String lastName, String email, String password, 
                   String month, String day, String year, String address, String city, String state, 
                   String zipcode, String cardNumber, String CVC, String EXPDate){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.month = month;
        this.day = day;
        this.year = year;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.cardNumber = cardNumber;
        this.CVC = CVC;
        this.EXPDate = EXPDate;
        AccountManager.addAccount(this);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
    
    public void addListing(int listingID){
        listings.add(listingID);
        listingCount++;
    }

    public void postNewListing(String[] info, ArrayList<Image> pictures){
        Listing newListing = new Listing(this, info[0], info[1], info[2], 
                                         info[3], info[4], info[5], info[6], 
                                         info[7], info[8], info[9], pictures);
    }
}

