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

    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("hellofx.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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
        System.out.println("Password: " + password);
    }

    

}
