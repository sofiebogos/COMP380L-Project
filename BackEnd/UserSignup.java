import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
    //Variables do not match frontend code at the moment
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String FirstName = txtFirstName.getText();
        String LastName = txtLastName.getText();
        String Email = txtEmail.getText();
        String Password = txtPassword.getText();
        int DOBMonth = Integer.parseInt(txtDOBMonth.getText());
        int DOBDay = Integer.parseInt(txtDOBDay.getText());
        int DOBYear = Integer.parseInt(txtDOBYear.getText());
        String Address = txtAddress.getText();
        String City = txtCity.getText();
        String State = txtState.getText();
        int ZipCode = Integer.parseInt(txtZIPcode.getText());
        String CardNum = txtCardNum.getText();
        int CVC = Integer.parseInt(txtCVC.getText());
        String ExpDate = txtExpDate.getText();

        //Read and write to file
        appendToFile("UserSignup.txt", FirstName + "," + LastName + "," + Email + "," + Password + "," + DOBMonth + "," + DOBDay + "," + DOBYear + "," + Address + "," + City + "," + State + "," + ZipCode + "," + CardNum + "," + CVC + "," + ExpDate);
    }

    public static void appendToFile(String filename, String content) {
        Path path = Paths.get(filename);

        try {
            if (!ReadFile.Compare(content)) {
                Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Successfully wrote to the file.");
            }
          //Exception message if writing to file fails
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}

