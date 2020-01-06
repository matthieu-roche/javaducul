package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {
	


	
	public static void main(String[] args) {


		launch(args);

		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
			primaryStage.setTitle("TBF Game");
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} 
	
	
	}
	

