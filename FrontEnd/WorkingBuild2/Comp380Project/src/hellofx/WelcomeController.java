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
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeController implements Initializable{
    @FXML
    private Label name;
    @FXML
    private Button browseCar, sellYourCar;
    @FXML
    private Hyperlink search;

    private Stage stage; 
    private Scene scene;
    private Parent root;    

    public void switchToAllListings(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("allListings.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPostNewCar(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("PostNewCar.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("postcar.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL location, ResourceBundle resources){
        name.setText(AccountManager.currentAccount.getFirstName() + " " +  AccountManager.currentAccount.getLastName() + "!");
    }

    public void gotToSearch(ActionEvent hyperlink)throws IOException{
        root = FXMLLoader.load(getClass().getResource("search.fxml"));
        stage = (Stage)((Node)hyperlink.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSignin (ActionEvent signin ) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)signin.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void logOut(ActionEvent hyperlink) throws IOException{
        AccountManager.currentAccount = null;
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)hyperlink.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("home.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
