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
	private String mainthemeColor = "#C0C0C0";
	private float buttonSize =  80f;
	@Override
	public void start(Stage primaryStage) {
		try {
		
			
			//===============================================================
			// Input data Pane
			GridPane inputDataPane = new GridPane();
			inputDataPane.setPadding(new Insets(10, 10, 10, 10));
			inputDataPane.setVgap(5);
			
			// Data source input text field
			Label dataSource = new Label(" Data Source _Name: ");
			dataSource.setMnemonicParsing(true);
		
			TextField dataSourceText = new TextField ();
			dataSourceText.setMinWidth(260);
			
			// Data description input text field
			Label description = new Label(" _Description: ");
			description.setMnemonicParsing(true);
			
			TextField descriptionText = new TextField ();
			descriptionText.setMinWidth(260);
			
			
			inputDataPane.add(dataSource, 0,0);
			inputDataPane.add(dataSourceText, 1,0);
			inputDataPane.add(description, 0,1);
			inputDataPane.add(descriptionText, 1,1);
			
			//===============================================================
			// Label Pane
			
			GridPane labelPanel = new GridPane();
			labelPanel.setPadding(new Insets(10, 10, 10, 10));
			labelPanel.setHgap(12);
			
			Label databaseLbl = new Label("Database: ");
			
			// All buttons
			Button  selectButton = new Button("_Select...");
			selectButton.setPrefWidth(buttonSize);
			selectButton.setMnemonicParsing(true);
			
			Button  createButton = new Button("_Create...");
			createButton.setPrefWidth(buttonSize);
			createButton.setMnemonicParsing(true);
			
			Button  repairButton = new Button("_Repair...");
			repairButton.setPrefWidth(buttonSize);
			repairButton.setMnemonicParsing(true);
			
			Button  compactButton = new Button("Co_mpact...");
			compactButton.setPrefWidth(buttonSize);
			compactButton.setMnemonicParsing(true);
			
			
			labelPanel.add(databaseLbl, 0, 0);
			labelPanel.add(selectButton, 0, 1);
			labelPanel.add(createButton, 1, 1);
			labelPanel.add(repairButton, 2, 1);
			labelPanel.add(compactButton, 3, 1);
			
			// Add border and title to panel
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
			
			// All buttons
			Button OKbutton = new Button("OK");
			OKbutton.setPrefWidth(buttonSize);
			
			Button cancelbutton = new Button("Cancel");
			cancelbutton.setPrefWidth(buttonSize);
			
			Button helpButton = new Button("_Help");
			helpButton.setPrefWidth(buttonSize);
			helpButton.setMnemonicParsing(true);
			
			Button advancedButton = new Button("_Advanced...");
			advancedButton.setPrefWidth(buttonSize);
			advancedButton.setMnemonicParsing(true);
			
			
			leftSideButtons.getChildren().addAll(OKbutton,cancelbutton,helpButton,advancedButton);
			//===============================================================
			// System Data Base Panel

			VBox  systemDataBasePanel = new VBox();
			systemDataBasePanel.setSpacing(10);
			systemDataBasePanel.setPadding(new Insets(30, 10, 15, 10));
			
			// Two check Box
			RadioButton noneButton = new RadioButton("Non_e");
			noneButton.setMnemonicParsing(true);
			RadioButton databaseButton = new RadioButton("Da_tabase");	
			databaseButton.setMnemonicParsing(true);
			
			// System database button
			Button systemDataButton = new Button("S_ystem Database...");
			systemDataButton.setStyle("-fx-translate-x: 100\n;");
			systemDataButton.setMnemonicParsing(true);
			

			systemDataBasePanel.getChildren().addAll(noneButton, databaseButton, systemDataButton);
			
			// Add border and title to panel
			StackPane bottomLeftPanel = CreateBorderAndTile(systemDataBasePanel, "System Database");
			
			
			//========================================================================
			// Bottom right button
			Button optionButton = new Button("_Options>>");
			optionButton.setPrefWidth(buttonSize);
			optionButton.setMnemonicParsing(true);
			
			optionButton.setStyle("-fx-translate-x: 20\n;" + "-fx-translate-y: 35\n;");
			
			
			//========================================================================
			// Root
			GridPane root = new GridPane();
			
			// Put all panel together
			root.add(dataPane_LabelPane, 0, 0);
			root.add(leftSideButtons, 1, 0);
			root.add(bottomLeftPanel, 0, 1);
			root.add(optionButton, 1, 1);
			
			root.setStyle("-fx-background-color:" + mainthemeColor + ";");
			
		
			
			
			Scene scene = new Scene(root, 500, 300);
			
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
				 "-fx-background-color: " + mainthemeColor + ";\n";

				
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
