package hellofx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class controller {
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

    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

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
        System.out.println("Create Account info:"+email2+ password2+ DOBmonth + DOBday +DOByear + address + city + state + ZIP + cardNumber + CVC + expDate);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreateAcc(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("createaccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private TextField emailtext;

    @FXML
    private TextField passwordtext;
 
    @FXML
    public void Enter(ActionEvent e) {
        String email = emailtext.getText();
        String password = passwordtext.getText();

        System.out.println("You have successfully logged in!"); 
        System.out.println("Email: " + email);
        System.out.println("Password: " + password + email);
    }

    

}
