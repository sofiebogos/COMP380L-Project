package hellofx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;


    /**
     * This class is used to Controller for the page that displays listings.
     * @param i is simple index incrementer to keep track of which image to display.
     */

public class ListingController implements Initializable{
    Scene scene;
    Stage stage;
    Parent root;
    
    @FXML
    private ImageView carPic;

    @FXML
    private Button nextCar, previousCar, backButton;

    @FXML
    private Label condition, titleStatus, yearMakeModel, mileage, zip, price, desc;


    int i=0;
    private static int id;

    public static void setID(int i){
        id = i;
    }

    public void openListing(){
        String[] listingInfo = ListingManager.getListing(id).getVars();
        carPic.setImage(ListingManager.getListing(id).getPictures().get(0));
        condition.setText(listingInfo[0]);
        titleStatus.setText(listingInfo[1]);
        yearMakeModel.setText(listingInfo[2] + " " + listingInfo[3] + " " + listingInfo[4]);
        mileage.setText(listingInfo[5]);
        zip.setText(listingInfo[6]);
        price.setText("$" + listingInfo[7]);
        desc.setText(listingInfo[8]);
        this.id = id;
    }

        /**
         * This method sets the displaying image to the next image in the listing's list.
         */
    public void nextImage(){
        if (i >= ListingManager.getListing(id).getPictures().size() -1){
            i = 0;
        }
        else {
            i++;
        }
            carPic.setImage((ListingManager.getListing(id).getPictures()).get(i));
    }

        /**
         * This method sets the displaying image to the previous image in the listing's list. 
         */
    public void previousImage(){
        if (i == 0){
            i = ListingManager.getListing(id).getPictures().size() -1;
        }
        else {
            i--;
        }
            carPic.setImage(ListingManager.getListing(id).getPictures().get(i));
    }
public void goBack(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("allListings.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

@Override
public void initialize(URL location, ResourceBundle resources) {
    openListing();
}

}
