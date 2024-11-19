package hellofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PostingController implements Initializable {

    @FXML
    private ChoiceBox<Integer> year;

    private int[] years = new int[100];

    for (int i = 0; i < 100; i++){
        years[i] = 2000;
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        
    }

}