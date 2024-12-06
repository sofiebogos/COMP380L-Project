package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * opens GUI
 * @author Allison Vanegas
 */
public class OtherMain extends Application {
     /**
     * sets opening scene to home page
     */

    public static void switchView(String fxmlFile) {
        try {
            Stage stage = new Stage();
            Image icon = new Image("CarPics\\luigi.gif");
            stage.getIcons().add(icon);
            stage.setTitle("Jams Auto Sales");
            Parent root = FXMLLoader.load(OtherMain.class.getResource(fxmlFile));
            Scene scene = new Scene(root, Color.GRAY);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception{
        PostNewCarController.populateLists();
		ListingManager.addDefaultPics();
		ReadFile.addDefaultListings(AccountManager.getDefaultAccount());
		Image icon = new Image("CarPics\\luigi.gif");
		stage.getIcons().add(icon);
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root);
        String css = getClass().getResource("home.css").toExternalForm();
        scene.getStylesheets().add(css);
        root.setStyle("-fx-background-color: white;");
        stage.setTitle("Jams Auto Sales");
        stage.setHeight(720);
        stage.setWidth(1280);
        stage.setScene(scene);
        stage.show(); //stage pops up 
    }


    public static void main(String[] args) {
        launch(args);
    }
}
