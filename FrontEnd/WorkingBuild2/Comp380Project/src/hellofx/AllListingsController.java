package hellofx;



import java.io.IOException;
import java.lang.Math;
import java.lang.classfile.instruction.ThrowInstruction;
import java.net.URL;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

// later reset the fxid of the button in the vbox using .setId("string") method -- make sure to use listing id as parameter
public class AllListingsController implements Initializable{
    private Stage stage; 
    private Scene scene;
    private Parent root;

    private boolean searched = false;

    @FXML
    private Button testAdd, browseCars;
    @FXML
    private VBox initialVBox;
    @FXML
    private FlowPane flowPaneRoot;
    @FXML
    private AnchorPane initialAnchorPane;
    @FXML
    private Label name, logo;
    @FXML
    private TextField searchtext;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        for (Listing listing : ListingManager.getAllListings()){
        int id = listing.getID();
        addListing(id);
    }
        //name.setText(AccountManager.currentAccount.getFirstname());
    }

    public void addListing(){ //for testing only
        flowPaneRoot.setPrefHeight(flowPaneRoot.getPrefHeight() + 150.0);
        flowPaneRoot.getChildren().add(new VBox(getAnchorPane()));
    }

    public void addListing(int id){
        Listing nextListing = ListingManager.getListing(id);
        DecimalFormat priceFormat = new DecimalFormat("#,###");
        String price = priceFormat.format(Integer.parseInt(nextListing.getVars()[7]));
        flowPaneRoot.setPrefHeight(flowPaneRoot.getPrefHeight() + 185.0);
        AnchorPane nextListingAP = getAnchorPane();
        ((ImageView) nextListingAP.getChildren().get(0)).setImage((Image) nextListing.getPictures().get(0));
        ((Label) nextListingAP.getChildren().get(1)).setText(nextListing.getVars()[2] + " " + 
                                                                   nextListing.getVars()[3] + " " + 
                                                                   nextListing.getVars()[4] + " "  );
        ((Label) nextListingAP.getChildren().get(2)).setText("$" + price);
        ((Button) nextListingAP.getChildren().get(3)).setId("B" + Integer.toString(nextListing.getID()));
        ((Button) nextListingAP.getChildren().get(3)).setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                try {
                    openListing(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        flowPaneRoot.getChildren().add(new VBox(nextListingAP));
    }

    public void goBack(MouseEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("successfulLogin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        returnAP.setMinWidth(850.0);
        returnAP.setStyle("-fx-border-color: gray; -fx-border-width: 2; -fx-border-style: solid;");

        return returnAP;
    }

    public void openListing(ActionEvent e) throws IOException{
        Button button = (Button) e.getSource();
        int id = Integer.parseInt((button.getId()).substring(1));
        ListingController.setID(id);
        root = FXMLLoader.load(getClass().getResource("listing.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

        public void search(ActionEvent e) throws IOException{
        ArrayList<Listing> searchResults = ListingManager.searchCars(searchtext.getText());
        root = FXMLLoader.load(getClass().getResource("listing.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        for (Listing listing : searchResults){
            int id = listing.getID();
            addListing(id);
        }
    }
}