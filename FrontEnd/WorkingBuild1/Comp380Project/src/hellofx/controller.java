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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
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
    private TextField createFirst, createLast, createEmail, createMonthDOB,
                      createDayDOB, createYearDOB, createAddress, createCity, createState,
                      createZIP, createCardnum, createCVC, createExp;
    
    @FXML
    private PasswordField createPassword, confirmPassword;
    @FXML
    private Label matcherror, emptyfield;

    @FXML
    private ComboBox<String> createMonth;
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    @FXML
    private ComboBox<Integer> createDay;
    @FXML
    private ComboBox<Integer> createYear;
    @FXML
    private Button login;
    @FXML
    private Hyperlink search;
    
    /**
     * Receives create account information and switches the scene to Login page.
     * @param enter click enter button in Create Account page
     * @throws IOException
     */
    public void switchToLogin(ActionEvent enter) throws IOException{
        String firstName = createFirst.getText();
        String lastName = createLast.getText();
        String email = createEmail.getText();
        String password = createPassword.getText();
        String password2 = confirmPassword.getText(); // For password value to save use VeryBadHash in Login. MUST be saved in that form
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
        String salt = Account.generateHex();

        String[] textFields = {firstName, lastName, email, password, password2, DOBmonth,address, city, state, ZIP, cardNumber, CVC, expDate};
        boolean empty = false;
        for(int i=0; i<13; i++){
            if(textFields[i].isEmpty() || DOBday == null || DOByear == null){
                empty = true;
                emptyfield.setText("Please fill out all required fields.");
                break;
            }
        }
        matcherror.setText("");
       if(password.equals(password2) && empty==false){
            String passHash = Login.VeryBadHash(password2, salt);
            UserSignup.appendToFile("account", firstName + ";" + lastName + ";" + email + ";" + passHash + ";" + DOBmonth + ";" + DOBday + ";" + DOByear + ";" + address + ";" + city + ";" + state + ";" + ZIP + ";" + cardNumber + ";" + CVC + ";" + expDate + ";" + salt);
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = (Stage)((Node)enter.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = this.getClass().getResource("login.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }
        else if(!password.equals(password2) && empty==false){
            matcherror.setText("The passwords you entered do not match.");
            emptyfield.setText("");
        }
        else if(!password.equals(password2) && empty == true)
            matcherror.setText("The passwords you entered do not match.");

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
        String css = this.getClass().getResource("createaccount.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void gotToSearch(ActionEvent hyperlink)throws IOException{
        root = FXMLLoader.load(getClass().getResource("search.fxml"));
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
        String css = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
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
    ReadFile.ReadAccount();
    if (Login.auth(email, password) == false){
        System.out.println("Account email and password combination does not exist!");
    }
    else{
        AccountManager.setCurrentAccount(AccountManager.getAccount(email));
        //OtherMain.switchView("allListings.fxml");
        root = FXMLLoader.load(getClass().getResource("successfulLogin.fxml"));
        stage = (Stage)((Node)enter.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("successfulLogin.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
    public void login(){

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
