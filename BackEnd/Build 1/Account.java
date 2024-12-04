import java.util.ArrayList;

public class Account{
    private String firstName, lastName, email, password;
    private int[] DOB = new int[3];
    private String city, state, street;
    private int zipcode;
    public int listingCount = 0;
    private ArrayList<Integer> listings = new ArrayList<>();
    public Account(String firstName, String lastName, String email, String password, int[] DOB, String city, String state, String street){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
        this.city = city;
        this.state = state;
        this.street = street;
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

