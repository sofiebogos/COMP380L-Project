package hellofx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javafx.event.ActionEvent;

//Declare class
public class UserSignup {

    public UserSignup() {
        initComponents();
    }
    //Main methods
    public static void main(String[] args) {

    }

    private void initComponents() {

    }
    //Declare variables to user input
    private void jButton1ActionPerformed(ActionEvent evt) {
        String firstName = createFirst.getText();
        String lastName = createLast.getText();
        String email2 = createEmail.getText();
        String password2 = createPassword.getText();
        String DOBmonth = createMonthDOB.getText();
        String DOBday = createDayDOB.getText();
        String DOByear = createYearDOB.getText();
        String address = createAddress.getText();
        String city = createCity.getText();
        String state = createState.getText();
        String ZIP = createZIP.getText();
        String cardNumber = createCardnum.getText();
        String CVC = createCVC.getText();
        String expDate = createExp.getText();

        UserSignup.appendToFile("account.txt", firstName + ";" + lastName + ";" + email2 + ";" + password2 + ";" + DOBmonth + ";" + DOBday + ";" + DOByear + ";" + address + ";" + city + ";" + state + ";" + ZIP + ";" + cardNumber + ";" + CVC + ";" + expDate + ";");
    }

    public static void appendToFile(String filename, String content) {
        String fullpath = System.getProperty("user.dir") + File.separator + "FrontEnd" + File.separator + "WorkingBuild1" + File.separator + "Comp380Project" + File.separator + "src" + File.separator + 
                  "TextFiles" + File.separator + filename + ".txt";
        Path path = Paths.get(fullpath);
        try {
            if (ReadFile.Compare(content, "account") != true) {
                content = content + "\n";
                Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Successfully wrote to the file.");
            }
            //Exception message if writing to file fails
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}


