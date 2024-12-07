package hellofx;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

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

    private Stage stage; 
    private Scene scene;
    private Parent root;

    @FXML
    private TextField model, mileage, zip, price;
    @FXML
    private TextArea desc;
    @FXML
    private ComboBox<Integer> year;
    @FXML
    private ComboBox<String> make, color, condition, titleStatus;
    @FXML
    private Button addPics, postListing;
    @FXML
    private Hyperlink backButton;

    private static boolean hasInitialized = true;
    private static Integer[] years;
    private static String[] makes, colors, conditions, listTitleStatus;
    private Account currentAccount;
    private ArrayList<Image> pictures;

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
        //pictures.add(someImage);
    }

    public void goBack(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("successfulLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void postCar(ActionEvent e){
        String year, make, model, color, mileage, condition, titleStatus, zip, price, desc;
        year = Integer.toString(this.year.getSelectionModel().getSelectedItem());
        make = this.make.getSelectionModel().getSelectedItem();
        model = this.model.getText();
        color = this.color.getSelectionModel().getSelectedItem();
        mileage = this.mileage.getText();
        condition = this.condition.getSelectionModel().getSelectedItem();
        titleStatus = this.titleStatus.getSelectionModel().getSelectedItem();
        zip = this.zip.getText();
        price = this.price.getText();
        desc = this.desc.getText();
        String[] carInfo = {year, make, model, color, mileage, condition, titleStatus, zip, price, desc};
        currentAccount.postNewListing(carInfo, pictures);
    }
    public void switchToSignin (ActionEvent signin) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)signin.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAllListings(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("allListings.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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