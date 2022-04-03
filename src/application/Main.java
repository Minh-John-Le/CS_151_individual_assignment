package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private String title = "ODBC Microsoft Acces Setup";
	@Override
	public void start(Stage primaryStage) {
		try {
			

			
			GridPane root = new GridPane();
			
			// Input data Pane
			GridPane inputDataPane = new GridPane();
			
			inputDataPane.setPadding(new Insets(10, 10, 10, 10));
			
			Label dataSource = new Label(" Data Source Name: ");
			TextField dataSourceText = new TextField ();
			
			dataSourceText.setMinWidth(200);
			Label description = new Label(" Description: ");
			TextField descriptionText = new TextField ();
			descriptionText.setMinWidth(200);
			
			inputDataPane.add(dataSource, 0,0);
			inputDataPane.add(dataSourceText, 1,0);
			inputDataPane.add(description, 0,1);
			inputDataPane.add(descriptionText, 1,1);
			
			
			// Label Pane
			GridPane labelPanel = new GridPane();
			
			Label databaseCaptionLbl = new Label("Database");
			Label databaseLbl = new Label("Database: ");
			
			Button  selectButton = new Button("Select...");
			Button  createButton = new Button("Create...");
			Button  repairButton = new Button("Repair...");
			Button  compactButton = new Button("Compact...");
			
			labelPanel.add(databaseLbl, 0, 0);
			labelPanel.add(selectButton, 0, 1);
			labelPanel.add(createButton, 1, 1);
			labelPanel.add(repairButton, 2, 1);
			labelPanel.add(compactButton, 3, 1);
			
			// Root
			root.add(inputDataPane, 0, 0);
			root.add(labelPanel, 0, 1);
			
			
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle(title);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
