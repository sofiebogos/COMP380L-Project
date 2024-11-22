import java.util.ArrayList;

public class Account{
    private String firstName, lastName, email, password;
    private String[] DOB = new String[3];
    private String city, state, address, EXPDate, zipcode;
    private int cardNumber, CVC;
    public int listingCount = 0;
    private ArrayList<Integer> listings = new ArrayList<>();

    public Account(String firstName, String lastName, String email, String password, 
                   String[] DOB, String address, String city, String state, 
                   String zipcode, int cardNumber, int CVC, String EXPDate           ){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
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

