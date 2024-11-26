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
public class Main extends Application {
     /**
     * sets opening scene to home page
     */
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(root);
        root.setStyle("-fx-background-color: white;");
        stage.setTitle("Jams Auto Sales");
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setScene(scene);
        stage.show(); //stage pops up 
    }


    public static void main(String[] args) {
        launch(args);
    }
}
