package hellofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 * Changes the scenes of Interface
 * @author Allison Vanegas
 */
public class controller implements Initializable{
    private Stage stage; 
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField createFirst;
    @FXML
    private TextField createLast; 
    @FXML
    private TextField createEmail; 
    @FXML
    private TextField createPassword;
    @FXML
    private TextField createMonthDOB;
    @FXML
    private TextField createDayDOB;
    @FXML
    private TextField createYearDOB;
    @FXML
    private TextField createAddress;
    @FXML
    private TextField createCity;
    @FXML
    private TextField createState;
    @FXML
    private TextField createZIP;
    @FXML
    private TextField createCardnum;
    @FXML
    private TextField createCVC;
    @FXML
    private TextField createExp;
    @FXML
    private ComboBox<String> createMonth;
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    @FXML
    private ComboBox<Integer> createDay;
    @FXML
    private ComboBox<Integer> createYear;
    
    /**
     * Receives create account information and switches the scene to Login page.
     * @param enter click enter button in Create Account page
     * @throws IOException
     */
    public void switchToLogin(ActionEvent enter) throws IOException{
        String firstName = createFirst.getText();
        String lastName = createLast.getText();
        String email2 = createEmail.getText();
        String password2 = createPassword.getText();
        String DOBmonth = createMonth.getValue();
        Integer DOBday = createDay.getValue();
        Integer DOByear = createYear.getValue();
        String address = createAddress.getText();
        String city = createCity.getText();
        String state = createState.getText();
        String ZIP = createZIP.getText();
        String cardNumber = createCardnum.getText();
        String CVC = createCVC.getText(); 
        String expDate = createExp.getText();
    
        UserSignup.appendToFile("UserSignup.txt", firstName + ";" + lastName + ";" + email2 + ";" + password2 + ";" + DOBmonth + ";" + DOBday + ";" + DOByear + ";" + address + ";" + city + ";" + state + ";" + ZIP + ";" + cardNumber + ";" + CVC + ";" + expDate + ";");

        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)enter.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches scene to Create Account page.
     * @param hyperlink click hyperlink in Login page
     * @throws IOException
     */
    public void switchToCreateAcc(ActionEvent hyperlink) throws IOException{
        root = FXMLLoader.load(getClass().getResource("createaccount.fxml"));
        stage = (Stage)((Node)hyperlink.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches scene to Login Page.
     * @param sigin click sign in button in Home page
     * @throws IOException
     */
    public void switchToSignin (ActionEvent signin ) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)signin.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField emailtext;
    @FXML
    private TextField passwordtext;

 /**
  * Receives input of email and password and switches scene to Home page.
  * @param enter click enter button in Login page
  * @throws IOException
  */
    public void Enter(ActionEvent enter) throws IOException {
        String email = emailtext.getText();
        String password = passwordtext.getText();
        System.out.println("You have successfully logged in!"); 
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        ReadFile.ReadAccount("UserSignup.txt");

        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)enter.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(createMonth != null)
            createMonth.getItems().addAll(months);

        if(createDay != null){
            int i;
            for(i=1; i<=31; i++)
            createDay.getItems().addAll(i);
        }

        if(createYear != null){
            int i;
            for(i=2024; i>=1920; i--)
                createYear.getItems().addAll(i);
        }
    }
}
