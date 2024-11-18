import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        //Declare variables
        String correctEmail = "jams03@gmail.com";
        String correctPassword = "Mcqueen101";
        String filename = "UserSignup.txt";
        String firstName = "Jams";
        String lastName = "Jameson";
        String Email = "jams03@gmail.com";
        String Password = "Mcqueen101";
        int MonthDOB = 10;
        int DayDOB = 20;
        int YearDOB = 2003;
        String Address = "12345 Street Drive";
        String City = "Los Angeles";
        String State = "CA";
        int ZIP = 90123;
        String Cardnum = "1234 5678 9000";
        int CVC = 123;
        String Exp = "10/29";

        String content = "";

        //Content to declared variables
        content = content + '\n' + firstName + ", " + lastName + ", " + Email + ", " + Password + ", " +
                MonthDOB + ", " + DayDOB + ", " + MonthDOB + ", " + Address + ", " + City + ", " + State +
                ", " + ZIP + ", " + Cardnum + ", " + CVC + ", " + Exp;

        Scanner input = new Scanner(System.in);

        //User Input for email associated with their account
        System.out.println("Email: ");
        String username = input.next();

        //User Input for password associated with their account
        System.out.println("Enter Password: ");
        String password = input.next();

        //Check user email and password input
        if (username.equals(correctEmail) && password.equals(correctPassword)) {
            System.out.println("Welcome!");
        } else if (username.equals(correctEmail)) {
            System.out.println("Invalid Password");
        } else if (password.equals(correctPassword)) {
            System.out.println("Invalid Email");
        } else {
            System.out.println("Invalid Email and Password");
        }

        //Close scanner
        input.close();
    }
}

