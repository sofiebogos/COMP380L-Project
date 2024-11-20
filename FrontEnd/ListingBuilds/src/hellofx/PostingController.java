package hellofx;

import java.awt.Button;
import java.awt.Choice;
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
    @FXML
    private ChoiceBox<String> make;
    @FXML
    private ChoiceBox<String> color;
    @FXML
    private ChoiceBox<String> condition;
    @FXML
    private ChoiceBox<String> titleStatus;
    @FXML
    private Button addPics;
    @FXML
    private Button postListing;

    private static boolean hasInitialized = true;
    private static Integer[] years;
    private static String[] makes;
    private static String[] colors;
    private static String[] conditions;
    private static String[] listTitleStatus;

    public static void populateLists(){
        years = SellCarData.getYears();
        makes = SellCarData.getMakes();
        colors = SellCarData.getColors();
        conditions = SellCarData.getConditions();
        listTitleStatus = SellCarData.getTitleStatus();
    }
    



    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        year.getItems().addAll(years);
        make.getItems().addAll(makes);
        color.getItems().addAll(colors);
        condition.getItems().addAll(conditions);
        titleStatus.getItems().addAll(listTitleStatus);
    }

}