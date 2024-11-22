package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import java.util.ArrayList;
import java.util.Iterator;


// **Extra Stage methods**
// myStage.setWidth(420);
// myStage.setHeight(420);
// myStage.setResizable(false);
// myStage.setX(50); // changes the position of where window appears
// myStage.setY(50); //
// myStage.setFullScreen(true);
// myStage.setFullScreenExitHint("YOU'RE TRAPPED FOREVER... unless you throw an 'f' into chat ya mofo"); 
// myStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("f")); // changes the escape key for escaping fullscreen from ESC

// **How to add and modify text**
// Text text = new Text();
// text.setText("Yeah Buddy!");
// text.setX(50); //changes position of text 
// text.setY(50);
// text.setFont(Font.font("Times New Roman", 24));
// text.setFill(Color.RED); //changes color 
// root.getChildren().add(text);

// **Drawing lines** 
// Line line = new Line();
// line.setStartX(100); //begins x coordinate
// line.setStartY(100); //begins y cordinate
// line.setEndX(500);
// line.setEndY(100);
// line.setStrokeWidth(10); //changes line thickness
// line.setStroke(Color.RED); // changes color
// line.setOpacity(0.5); // changes level or transparancy
// line.setRotate(45);
// root.getChildren().add(line);

// **Drawing shapes**
// Rectangle rectangle = new Rectangle();
// rectangle.setWidth(400);
// rectangle.setHeight(400);
// rectangle.setX(100);
// rectangle.setY(100);
// rectangle.setFill(Color.BROWN);
// rectangle.setStrokeWidth(10);
// rectangle.setStroke(Color.BLACK);
// root.getChildren().add(rectangle);
// -----------------------------------
// Circle circle = new Circle();
// circle.setCenterX(1000); //sets center coordinates
// circle.setCenterY(500);
// circle.setRadius(200);
// circle.setFill(Color.GREEN);
// root.getChildren().add(circle);
// ---------------------------------------
// Polygon triangle = new Polygon();
// triangle.getPoints().setAll(100.0,100.0,50.0,200.0,200.0,200.0); //sets (x,y) coordinates for all three corners
// triangle.setFill(Color.GOLD);
// root.getChildren().add(triangle);

// **Adding images**
// Image image = new Image("icon.gif");
// ImageView imageView = new ImageView(image);
// imageView.setX(400);
// imageView.setY(200);
// root.getChildren().add(imageView);

/**
	 * This class is used as the main starting point to Launch the javafx GUI.
	 * This class extends the Application class that exists within the javafx module.
	 */

public class Main extends Application {
	
	/**
	 * temporary ArrayList of images for testing purposes.
	 */
	public static ArrayList<Image> mcQueenPics = new ArrayList<>();
	/**
	 * temporary ArrayList Iterator for testing purposes.
	 */
	public static Iterator<Image> mcQueenIterator = mcQueenPics.iterator(); 

		/**
		 * This method Overrides the start method of the parent class.
		 * This method is used to set the required javafx elements to display a window.
		 */
	@Override
	public void start(Stage myStage)throws Exception{
		Image icon = new Image("CarPics\\luigi.gif");
		myStage.getIcons().add(icon);
		myStage.setTitle("Jams Auto Sales");

		Parent root = FXMLLoader.load(getClass().getResource("posting.fxml"));

		Scene scene = new Scene(root, Color.GRAY);
		myStage.setScene(scene);
		
		myStage.show();

	}

	public static void makeDefaultList(){
		for(int i = 1; i < 5; i++){
			mcQueenPics.add(new Image("CarPics\\mcqueen" + i +".jpg"));
		}
	}


		/**
		 * The starting point of the entire Application (Launches the Application).
		 */
    public static void main(String[] args) {
		makeDefaultList();
		PostingController.populateLists();
        launch(args);
    }
}