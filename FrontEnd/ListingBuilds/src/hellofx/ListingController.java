package hellofx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

    /**
     * This class is used to Controller for the page that displays listings.
     * @param i is simple index incrementer to keep track of which image to display.
     */

public class ListingController {

    
    @FXML
    ImageView carPic;
    Button nextCar;
    Button previuosCar;

    int i=0;

        /**
         * This method sets the displaying image to the next image in the listing's list.
         */
    public void nextImage(){
        if (i >= Main.mcQueenPics.size() -1){
            i = 0;
        }
        else {
            i++;
        }
            carPic.setImage(Main.mcQueenPics.get(i));
    }

        /**
         * This method sets the displaying image to the previous image in the listing's list. 
         */
    public void previousImage(){
        if (i == 0){
            i = Main.mcQueenPics.size() -1;
        }
        else {
            i--;
        }
            carPic.setImage(Main.mcQueenPics.get(i));
    }
}
