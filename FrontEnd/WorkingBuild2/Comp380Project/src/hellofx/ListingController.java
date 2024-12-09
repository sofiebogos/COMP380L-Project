package hellofx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;


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
    private TextField searchInfo;
    
    @FXML
    private ImageView carPic;

    @FXML
    private Button nextCar, previousCar, search;

    @FXML
    private Hyperlink backButton;

    @FXML
    private Label condition, titleStatus, yearMakeModel, mileage, zip, price, desc;


    int i=0;
    private static int id;

    public static void setID(int i){
        id = i;
    }

    public void openListing(){
        DecimalFormat priceFormat = new DecimalFormat("#,###");
        String[] listingInfo = ListingManager.getListing(id).getVars();
        String formattedMileage = priceFormat.format(Integer.parseInt(listingInfo[5]));
        String formattedPrice = priceFormat.format(Integer.parseInt(listingInfo[7]));
        carPic.setImage(ListingManager.getListing(id).getPictures().get(0));
        condition.setText(listingInfo[0]);
        titleStatus.setText(listingInfo[1]);
        yearMakeModel.setText(listingInfo[2] + " " + listingInfo[3] + " " + listingInfo[4]);
        mileage.setText(formattedMileage);
        zip.setText(listingInfo[6]);
        price.setText("$" + formattedPrice);
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

    public void searchListings(ActionEvent e) throws IOException{
        searchInfo.getText();

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

    public void switchToSignin (ActionEvent signin ) throws IOException{
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)signin.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

@Override
public void initialize(URL location, ResourceBundle resources) {
    openListing();
}

}
