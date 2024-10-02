package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller {
    public void Enter(ActionEvent e){
        System.out.println("You have successfully logged in!");
    }
@FXML
    private TextField textfield1;
    public void textfield(ActionEvent e){
        String username = textfield1.getText();
        System.out.println("You entered " + username);
        
    }
@FXML
    private TextField textfield2;
    public void othertextfield(ActionEvent e){
        String password = textfield2.getText();
        System.out.println("You entered " + password);
    }



}