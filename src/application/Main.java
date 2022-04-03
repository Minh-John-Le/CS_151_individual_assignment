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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	private String title = "ODBC Microsoft Access Setup";
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
			//===============================================================
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
			
			//===============================================================
			// Label Pane
			
			GridPane labelPanel = new GridPane();
			labelPanel.setPadding(new Insets(10, 10, 10, 10));
	
			

		
			Label databaseLbl = new Label("Database: ");
			Button  selectButton = new Button("Select...");
			Button  createButton = new Button("Create...");
			Button  repairButton = new Button("Repair...");
			Button  compactButton = new Button("Compact...");
			
			labelPanel.setHgap(15);
			labelPanel.add(databaseLbl, 0, 0);
			labelPanel.add(selectButton, 0, 1);
			labelPanel.add(createButton, 1, 1);
			labelPanel.add(repairButton, 2, 1);
			labelPanel.add(compactButton, 3, 1);
			
			
			StackPane finalLabelPanel = CreateBorderAndTile(labelPanel, "Database");
			
			//==============================================================
			//Putting Input data Pane and Label Pane  and left side button together
			
			VBox dataPane_LabelPane = new VBox();
			
			dataPane_LabelPane.getChildren().addAll(inputDataPane, finalLabelPanel);
			
			//==============================================================
			// Left side button
			VBox leftSideButtons = new VBox();
			leftSideButtons.setSpacing(10);
			leftSideButtons.setPadding(new Insets(10, 10, 10, 20));
			
			Button OKbutton = new Button("OK");
			OKbutton.setPrefWidth(80);
			Button Cancelbutton = new Button("Cancel");
			Cancelbutton.setPrefWidth(80);
			Button Helpbutton = new Button("Help");
			Helpbutton.setPrefWidth(80);
			Button Advancedbutton = new Button("Advanced...");
			Advancedbutton.setPrefWidth(80);
			
			leftSideButtons.getChildren().addAll(OKbutton,Cancelbutton,Helpbutton,Advancedbutton);
					
			//===============================================================
			// System Data Base Panel
		

			VBox  systemDataBasePanel = new VBox();
			RadioButton noneButton = new RadioButton("None");
			RadioButton databaseButton = new RadioButton("Database");	
			
			Button systemDataButton = new Button("System Database..");
			systemDataButton.setStyle("-fx-translate-x: 100\n;");
			
			systemDataBasePanel.getChildren().addAll(noneButton, databaseButton, systemDataButton);
			systemDataBasePanel.setSpacing(10);
			
			systemDataBasePanel.setPadding(new Insets(10, 10, 10, 10));
			
			StackPane bottomLeftPanel = CreateBorderAndTile(systemDataBasePanel, "System Database");
			
			
			//========================================================================
			// Bottom right button
			Button optionButton = new Button("Options>>");
			
			optionButton.setStyle("-fx-translate-x: 20\n;" + "-fx-translate-y: 35\n;");
			
			
			//========================================================================
			// Root
			GridPane root = new GridPane();
			
			root.add(dataPane_LabelPane, 0, 0);
			root.add(leftSideButtons, 1, 0);

			root.add(bottomLeftPanel, 0, 1);
			root.add(optionButton, 1, 1);
			
			root.setStyle("-fx-background-color:#A9A9A9;");
			Scene scene = new Scene(root, 500, 500);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle(title);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private StackPane CreateBorderAndTile(Pane pane, String title)
	{
		
		String cssLayout = "-fx-border-color: white;\n" +
	            "-fx-border-insets: 5;\n" +
	            "-fx-border-width: 1;\n" +
	            "-fx-border-style: solid;\n";
		
		
		String textStyle = "-fx-text-fill: black;\n"+   
				 "-fx-translate-x: 10\n;" +
				 "-fx-translate-y: -5\n;" +
				 "-fx-background-color: #A9A9A9;\n";

				
		Label borderTitle = new Label(title);
		borderTitle.setStyle(textStyle);
		
		pane.setStyle(cssLayout);
		
		StackPane result = new StackPane();
		result.getChildren().addAll(pane, borderTitle);
		
		
	
		
		StackPane.setAlignment(borderTitle, Pos.TOP_LEFT);

		
		return result;
	}
			
			
			
	public static void main(String[] args) {
		launch(args);
	}
}
