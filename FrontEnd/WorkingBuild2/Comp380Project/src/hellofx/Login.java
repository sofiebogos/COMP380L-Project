package hellofx;

public class Login {
    private String userEmail, userPassword, filename, firstName, lastName, address, city, state, cardNumber, expirationDate;
    private int monthOfBirth, dayOfBirth, yearOfBirth, zipCode, cvcCode;

    // public static void main(String[] args) {

    //     //Declare variables
    //     String correctEmail = "jams03@gmail.com";
    //     String correctPassword = "Mcqueen101";
    //     String filename = "UserSignup.txt";
    //     String firstName = "Jams";
    //     String lastName = "Jameson";
    //     String Email = "jams03@gmail.com";
    //     String Password = "Mcqueen101";
    //     int MonthDOB = 10;
    //     int DayDOB = 20;
    //     int YearDOB = 2003;
    //     String Address = "12345 Street Drive";
    //     String City = "Los Angeles";
    //     String State = "CA";
    //     int ZIP = 90123;
    //     String Cardnum = "1234 5678 9000";
    //     int CVC = 123;
    //     String Exp = "10/29";

    //     String content = "";

    //     //Content to declared variables
    //     content = content + '\n' + firstName + ", " + lastName + ", " + Email + ", " + Password + ", " +
    //             MonthDOB + ", " + DayDOB + ", " + MonthDOB + ", " + Address + ", " + City + ", " + State +
    //             ", " + ZIP + ", " + Cardnum + ", " + CVC + ", " + Exp;

    //     Scanner input = new Scanner(System.in);

    //     //User Input for email associated with their account
    //     System.out.println("Email: ");
    //     String username = input.next();

    //     //User Input for password associated with their account
    //     System.out.println("Enter Password: ");
    //     String password = input.next();

    //     //Check user email and password input



    //     //Close scanner
    //     input.close();
    // }

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

