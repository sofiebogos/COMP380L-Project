package hellofx;

import java.util.Scanner;

public class Login {
    private String userEmail, userPassword, filename, firstName, lastName, address, city, state, cardNumber, expirationDate;
    private int MonthDOB, DayDOB, YearDOB, zipCode, cvcCode;

    public static void main(String[] args) {

        //Declare variables
        String correctEmail = "john.doe@example.com";
        String correctPassword = "password123";
        String filename = "account.txt";
        String firstName = "John";
        String lastName = "Doe";
        String userEmail = "john.doe@example.com";
        String userPassword = "password123";
        int MonthDOB = 01;
        int DayDOB = 15;
        int YearDOB = 1990;
        String address = "123 Main Street";
        String city = "Los Angeles";
        String state = "CA";
        int zipCode = 90001;
        String cardNumber = "123 5678 789";
        int cvcCode = 123;
        String expirationDate = "12/29";

        String content = "";

        //Content to declared variables
        content = content + '\n' + firstName + ", " + lastName + ", " + userEmail + ", " + userPassword + ", " +
                MonthDOB + ", " + DayDOB + ", " + MonthDOB + ", " + address + ", " + city + ", " + state +
                ", " + zipCode + ", " + cardNumber + ", " + cvcCode + ", " + expirationDate;

        Scanner input = new Scanner(System.in);

        //User Input for email associated with their account
        System.out.println("Email: ");
        String username = input.next();

        //User Input for password associated with their account
        System.out.println("Enter Password: ");
        String password = input.next();

        //Check user email and password input



        //Close scanner
        input.close();
    }

    public static boolean auth(String email, String password){
        String salt = AccountManager.getSalt(email);
        if (salt == null){
            System.out.println("Wrong Email");
            return false; 
        }
        if (authHelper(email, password, salt) == true){
            System.out.println("Welcome!");
            return true; 
        } else {
            System.out.println("Invalid Password");
            return false; 
        }
    }

    public static boolean authHelper(String userEmail, String userPassword, String salt) {
        String finalPass = VeryBadHash(userPassword, salt);
        String toFind = userEmail + ";" + finalPass; 
        String result = ReadFile.FindAndReturn(toFind, "account");
        return !result.equals("0");
    }

    public static String VeryBadHash(String text, String salt){
        try {
            text = salt + text; 
            byte[] myBytes = text.getBytes("UTF-8");
            int length = myBytes.length;
            byte[] myHash = new byte[length];
            StringBuilder myHexString = new StringBuilder(); 
            for (int i = 0; i < myBytes.length; i++){
                myHash[i] = (byte) ((myBytes[i] * (1 << i)) & 0xFF);
                String hex = Integer.toHexString(0xff & myHash[i]);
                if (hex.length() == 1) { 
                    myHexString.append('0'); // Pad single-digit hex values
                }
                myHexString.append(hex);
            }

            return myHexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}



