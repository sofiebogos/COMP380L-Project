package hellofx;

import java.awt.Choice;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/** 
 * This class is the GUI controller for the Post-a-listing page.
 * @param hasInitilialized The boolean that is flipped when the lists have already been populated (reduces redundency).
 * @param years The array of year choices.
 * @param makes The array of make choices. 
 * @param colors The array of color choices.
 * @param conditions The array of condition choices. 
 * @param listTitleStatus The array of title status choices.
 */

public class PostNewCarController implements Initializable {

    @FXML
    private ComboBox<Integer> year, make, color, condition, titleStatus;
    @FXML
    private Button addPics, postListing;

    private static boolean hasInitialized = true;
    private static Integer[] years;
    private static String[] makes, colors, conditions, listTitleStatus;

        /**
         * This method populates the arrays used to provide the info for the Choice Boxes.
         */
    public static void populateLists(){
        years = SellCarData.getYears();
        makes = SellCarData.getMakes();
        colors = SellCarData.getColors();
        conditions = SellCarData.getConditions();
        listTitleStatus = SellCarData.getTitleStatus();
    }

    public void addCarPics(ActionEvent e){
        ArrayList<Image> tempList;
    }

    public void postCar(ActionEvent e){
        
    }
    


        /**
         * This method Overrides the Initilize method in the parent interface.
         * This method also passes along the correct arrays with the corresponding Choice Boxes.
         */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        year.getItems().addAll(years);
        make.getItems().addAll(makes);
        color.getItems().addAll(colors);
        condition.getItems().addAll(conditions);
        titleStatus.getItems().addAll(listTitleStatus);
    }

}