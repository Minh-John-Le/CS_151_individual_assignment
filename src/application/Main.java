package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	private String title = "ODBC Microsoft Acces Setup";
	
	private String cssLayout = "-fx-border-color: white;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 1;\n" +
            "-fx-border-style: solid;\n";
	
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
			StackPane stackPanelMiddle = new StackPane();
			
			GridPane labelPanel = new GridPane();
			labelPanel.setPadding(new Insets(10, 10, 10, 10));
			
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
			
			// System Data Base Panel
			
			
			StackPane bottomLeftPanel = new StackPane();
			
			GridPane systemDataBasePanel = new GridPane();
			systemDataBasePanel.setPadding(new Insets(10, 10, 10, 10));
			
			Label systemDatabaselbl = new Label("System Database");
			
			RadioButton noneButton = new RadioButton("None");
			RadioButton databaseButton = new RadioButton("Database");
			
			VBox  noneAndDataBtn = new VBox();
			
			

			noneAndDataBtn.getChildren().addAll(noneButton, databaseButton);

			systemDataBasePanel.setStyle(cssLayout);
			systemDataBasePanel.add(noneAndDataBtn, 0, 0);
			
			systemDatabaselbl.setPadding(new Insets(-5, 0, 0, 10));
			
			bottomLeftPanel.getChildren().addAll(systemDataBasePanel, systemDatabaselbl);
			
			bottomLeftPanel.setAlignment(systemDatabaselbl, Pos.TOP_LEFT);
			
			// Root
			root.add(inputDataPane, 0, 0);
			root.add(labelPanel, 0, 1);
			root.add(bottomLeftPanel, 0, 2);
			
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
