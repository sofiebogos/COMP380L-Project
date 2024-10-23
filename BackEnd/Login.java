import java.util.Scanner;

public class Login {

    public static void main(String[] args) {

        String correctUsername = "ilovebuyingcars03";
        String correctPassword = "Mcqueen101";

        Scanner input = new Scanner(System.in);

        // User Input for username
        System.out.println("Enter Username: ");
        String username = input.next();

        // User Input for password
        System.out.println("Enter Password: ");
        String password = input.next();

        // Check username and password
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Welcome!");
        } else if (username.equals(correctUsername)) {
            System.out.println("Invalid Password");
        } else if (password.equals(correctPassword)) {
            System.out.println("Invalid Username");
        } else {
            System.out.println("Invalid Username and Password");
        }

        // Close scanner
        input.close();
    }
}
