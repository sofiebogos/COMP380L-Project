package hellofx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListingController {

    //Listing currentListing = (some kind of input from the gui)
    
    @FXML
    ImageView carPic;
    Button nextCar;
    Button previuosCar;

    int i=0;

    public void nextImage(){
        if (i >= Main.mcQueenPics.size() -1){
            i = 0;
        }
        else {
            i++;
        }
            carPic.setImage(Main.mcQueenPics.get(i));
    }

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
