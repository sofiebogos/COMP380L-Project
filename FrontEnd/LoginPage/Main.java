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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
     
        primaryStage.setTitle("Car Shop");
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);
        primaryStage.setScene(scene);
        primaryStage.show(); //stage pops up 
    }


    public static void main(String[] args) {
        launch(args);
    }
}
