package hellofx;



import ListingManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


    /**
     * This class is used to Controller for the page that displays listings.
     * @param i is simple index incrementer to keep track of which image to display.
     */

public class ListingController {

    
    @FXML
    private ImageView carPic;

    @FXML
    private Button nextCar, previuosCar;

    @FXML
    private Label condition, titleStatus, yearMakeModel, mileage, zip, price, desc;


    int i=0;
    int id;

    public void openListing(int id){
        String[] listingInfo = ListingManager.getListing(id);
        condition.setText(listingInfo[0]);
        titleStatus.setText(listingInfo[1]);
        yearMakeModel.setText(listingInfo[2] + " " + listingInfo[3] + " " + listingInfo[4]);
        mileage.setText(listingInfo[5]);
        zip.setText(listingInfo[6]);
        price.setText(listingInfo[7]);
        desc.setText(listingInfo[8]);
        this.id = id;
    }

        /**
         * This method sets the displaying image to the next image in the listing's list.
         */
    private void nextImage(){
        if (i >= ListingManager.getListing(id).getPictures().size() -1){
            i = 0;
        }
        else {
            i++;
        }
            carPic.setImage(ListingManager.getListing(id).getPictures().size());
    }

        /**
         * This method sets the displaying image to the previous image in the listing's list. 
         */
    private void previousImage(){
        if (i == 0){
            i = ListingManager.getListing(id).getPictures().size() -1;
        }
        else {
            i--;
        }
            carPic.setImage(ListingManager.getListing(id).getPictures().size());
    }
}
