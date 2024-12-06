import java.util.ArrayList;

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
    }

    public String getFirstname(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    
    public void addListing(int listingID){
        listings.add(listingID);
        listingCount++;
    }
}

