package hellofx;



import java.lang.Math;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;





// later reset the fxid of the button in the vbox using .setId("string") method -- make sure to use listing id as parameter
public class AllListingsController{

    @FXML
    private Button testAdd;
    @FXML
    private VBox initialVBox;
    @FXML
    private FlowPane flowPaneRoot;
    @FXML
    private AnchorPane initialAnchorPane;
    
    public void addListing(){
        flowPaneRoot.setPrefHeight(flowPaneRoot.getPrefHeight() + 150.0);
        flowPaneRoot.getChildren().add(new VBox(getAnchorPane()));
    }

    public AnchorPane getAnchorPane(){
        ImageView returnIV = new ImageView(new Image("CarPics\\luigi.gif"));
        Label returnLabelOne = new Label("Year Make Model");
        Label returnLabelTwo = new Label("Price");
        Button returnButton = new Button("Check Out");

        returnIV.setFitWidth(256.0);
        returnIV.setFitHeight(152.0);
        returnIV.setLayoutX(14.0);
        returnIV.setLayoutY(16.0);
        returnIV.setPickOnBounds(true);
        returnIV.setPreserveRatio(true);
        
        returnLabelOne.setLayoutX(295.0);
        returnLabelOne.setLayoutY(28.0);
        returnLabelOne.setFont(new Font("Arial", 22.0));

        returnLabelTwo.setLayoutX(295.0);
        returnLabelTwo.setLayoutY(68.0);
        returnLabelTwo.setFont(new Font("Arial Bold", 26.0));

        returnButton.setLayoutX(295.0);
        returnButton.setLayoutY(123.0);
        returnButton.setMnemonicParsing(false);
        returnButton.setPrefHeight(26.0);
        returnButton.setPrefWidth(104.0);
        returnButton.setFont(new Font("Arial", 16.0));

        AnchorPane returnAP = new AnchorPane(returnIV, returnLabelOne, returnLabelTwo, returnButton);

        returnAP.setPrefHeight(200.0);
        returnAP.setPrefWidth(300.0);
        returnAP.setStyle("-fx-border-color: gray; -fx-border-width: 2; -fx-border-style: solid;");

        return returnAP;
    }
}