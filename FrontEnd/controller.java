package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller {
     @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    public void Enter(ActionEvent e) {
        String username = textfield1.getText();
        String password = textfield2.getText();

        System.out.println("You have successfully logged in!"); 
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }



}
