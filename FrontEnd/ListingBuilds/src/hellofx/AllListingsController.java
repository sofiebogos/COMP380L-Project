package hellofx;

import java.lang.Math;
import java.time.temporal.Temporal;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;

// later reset the fxid of the button in the vbox using .setId("string") method -- make sure to use listing id as parameter
public class AllListingsController{

    @FXML
    private Button testAdd;
    @FXML
    private VBox initial;
    @FXML
    private FlowPane flowPaneRoot;
    
    public void addListing(){
        VBox temp = initial;
        //AnchorPane tempPane = temp.getChildren(0)
        temp.setId("VB" + Integer.toString((int)Math.random()));
        temp.getChildren().get(0).setId("AP" + Integer.toString((int)Math.random()));
        ((AnchorPane) temp.getChildren().get(0)).getChildren().get(0).setId("Pic" + Integer.toString((int)Math.random()));
        ((AnchorPane) temp.getChildren().get(0)).getChildren().get(1).setId("YMM" + Integer.toString((int)Math.random()));
        ((AnchorPane) temp.getChildren().get(0)).getChildren().get(2).setId("Price" + Integer.toString((int)Math.random()));
        ((AnchorPane) temp.getChildren().get(0)).getChildren().get(3).setId("B" + Integer.toString((int)Math.random()));
        flowPaneRoot.getChildren().add(temp);
    }
}